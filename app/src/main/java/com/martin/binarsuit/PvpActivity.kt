package com.martin.binarsuit

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.martin.binarsuit.databinding.ActivityPvpBinding
import com.martin.binarsuit.databinding.DialogResultBinding
import com.martin.binarsuit.databinding.DialogViewBinding


class PvpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPvpBinding
    private lateinit var bindingDialog: DialogViewBinding
    private lateinit var bindingResultBinding: DialogResultBinding
    private lateinit var nameLogin: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPvpBinding.inflate(layoutInflater)
        val view = binding.root

        //getExtras
        nameLogin = intent.getStringExtra("name").toString()
        binding.tvPlayer.text = nameLogin

        setContentView(view) // 1. UI logic
        setUpAction() // 2. Game logic
        clearGame() // 3. Restarting the game logic. Me-restart logic game.
    }

    //Main logic for the game. Logic utama untuk game.
    private fun setUpAction() {
        rockGame()
        scissorGame()
        paperGame()
        binding.ivClose.setOnClickListener {
            val intentMain = Intent(this@PvpActivity, MenuActivity::class.java)
            intentMain.putExtra("name", nameLogin)
            startActivity(intentMain)
            finishAffinity()
        }
    }

    //Called if refresh button is clicked. Dipanggil ketika button Refresh diklik.
    private fun clearGame() {
        binding.apply {
            // 1. Click the refresh button to restart the game logic
            ivRefresh.setOnClickListener {
                Log.d(
                    "Refresh-click",
                    "User clicked the refresh button, game logic restarted from the UI ViewBinding; setting all ImageView resource to default."
                )
                sound()
                ivRockPlayer.apply { setBackgroundResource(0) }.apply { isClickable = true }
                ivPlayerScissor.apply { setBackgroundResource(0) }.apply { isClickable = true }
                ivPaperPlayer.apply { setBackgroundResource(0) }.apply { isClickable = true }
                ivRockCom.setBackgroundResource(0)
                ivScissorCom.setBackgroundResource(0)
                ivPaperCom.setBackgroundResource(0)
                ivResult.setImageResource(R.drawable.img_vs)
            }

            // 2. Long click refresh button to restart the activity
            ivRefresh.setOnLongClickListener {
                Log.d(
                    "Refresh-long-click",
                    "User long clicked the refresh button, activity restarted."
                )
                finish()
                startActivity(intent)
                true
            }
        }
    }

    //Disable all button
    private fun disableGame() {
        binding.apply {
            ivPaperPlayer.isClickable = false
            ivPlayerScissor.isClickable = false
            ivRockPlayer.isClickable = false
        }
    }

    //Called if player picked rock. Dipanggil ketika player memilih batu.
    private fun rockGame() {
        binding.apply {
            ivRockPlayer.setOnClickListener {
                Log.d("Batu", "User memilih batu")
                sound()
                ivRockPlayer.setBackgroundResource(R.drawable.bg_suit)
                ivPlayerScissor.setBackgroundResource(0)
                ivPaperPlayer.setBackgroundResource(0)
                ivResult.animate().apply {
                    duration = 200
                    rotationBy(360f)
                }.start()
                ivCensor.visibility = View.VISIBLE
                ivScissorCom.setOnClickListener {
                    ivScissorCom.setBackgroundResource(R.drawable.bg_suit)
                    Log.d("Play", "Player two memilih gunting")
                    ivResult.setImageResource(R.drawable.img_menang)
                    ivRockCom.setBackgroundResource(0)
                    ivPaperCom.setBackgroundResource(0)
                    disableGame()
                    dialogGame()
                    ivCensor.visibility = View.GONE
                    bindingResultBinding.tvResult.text = buildString {
                        append("$nameLogin\nMENANG!")
                    }
                }
                ivPaperCom.setOnClickListener {
                    ivPaperCom.setBackgroundResource(R.drawable.bg_suit).also {
                            Log.d("ComPaper", "Player two memilih kertas")
                            ivResult.setImageResource(R.drawable.img_menang2)
                            ivRockCom.setBackgroundResource(0)
                            ivScissorCom.setBackgroundResource(0)
                            disableGame()
                            dialogGame()
                            ivCensor.visibility = View.GONE
                            bindingResultBinding.tvResult.setText(R.string.result_win_two)
                        }
                }
                ivRockCom.setOnClickListener {
                    Log.d("ComRock", "Computer memilih batu")
                    ivRockCom.setBackgroundResource(R.drawable.bg_suit)
                    ivResult.setImageResource(R.drawable.img_draw)
                    ivScissorCom.setBackgroundResource(0)
                    ivPaperCom.setBackgroundResource(0)
                    disableGame()
                    dialogGame()
                    ivCensor.visibility = View.GONE
                    bindingResultBinding.tvResult.setText(R.string.result_draw)
                }
            }
        }

    }

    //Called if player picked scissor. Dipanggil ketika player memilih gunting.
    private fun scissorGame() {
        binding.apply {
            ivPlayerScissor.setOnClickListener {
                Log.d("Gunting", "User memilih gunting")
                sound()
                ivPlayerScissor.setBackgroundResource(R.drawable.bg_suit)
                ivRockPlayer.setBackgroundResource(0)
                ivPaperPlayer.setBackgroundResource(0)
                ivResult.animate().apply {
                    rotationBy(360f)
                    duration = 200
                }.start()
                ivCensor.visibility = View.VISIBLE
                ivScissorCom.setOnClickListener {
                    ivScissorCom.setBackgroundResource(R.drawable.bg_suit).also {
                            Log.d("Comp-Scissor", "Computer picked scissor")
                            ivResult.setImageResource(R.drawable.img_draw)
                            ivRockCom.setBackgroundResource(0)
                            ivPaperCom.setBackgroundResource(0)
                            disableGame()
                            dialogGame()
                            ivCensor.visibility = View.GONE
                            bindingResultBinding.tvResult.setText(R.string.result_draw)
                        }
                    ivRockCom.setOnClickListener {
                        ivRockCom.setBackgroundResource(R.drawable.bg_suit).also {
                                Log.d("Comp-Rock", "Computer picked rock")
                                ivResult.setImageResource(R.drawable.img_menang2)
                                ivScissorCom.setBackgroundResource(0)
                                ivPaperCom.setBackgroundResource(0)
                                disableGame()
                                dialogGame()
                                ivCensor.visibility = View.GONE
                                bindingResultBinding.tvResult.setText(R.string.result_win_two)
                            }
                        ivPaperCom.setOnClickListener {
                            ivPaperCom.setBackgroundResource(R.drawable.bg_suit).also {
                                    Log.d("Comp-Paper", "Computer picked paper")
                                    ivResult.setImageResource(R.drawable.img_menang)
                                    ivRockCom.setBackgroundResource(0)
                                    ivScissorCom.setBackgroundResource(0)
                                    disableGame()
                                    dialogGame()
                                    ivCensor.visibility = View.GONE
                                    bindingResultBinding.tvResult.text = buildString {
                                        append("$nameLogin\nMENANG!")
                                    }
                                }
                        }

                    }
                }
            }
        }

    }

    //Called if player picked paper. Dipanggil ketika player memilih kertas.
    private fun paperGame() {
        binding.apply {
            ivPaperPlayer.setOnClickListener {
                Log.d("Kertas", "User memilih kertas")
                sound()
                ivPaperPlayer.setBackgroundResource(R.drawable.bg_suit)
                ivRockPlayer.setBackgroundResource(0)
                ivPlayerScissor.setBackgroundResource(0)
                ivResult.animate().apply {
                    duration = 200
                    rotationBy(360f)
                }.start()
                ivCensor.visibility = View.VISIBLE
                ivScissorCom.setOnClickListener {
                    ivScissorCom.setBackgroundResource(R.drawable.bg_suit).also {
                            Log.d("Comp-Scissor", "Computer picked scissor")
                            ivResult.setImageResource(R.drawable.img_menang2)
                            ivRockCom.setBackgroundResource(0)
                            ivPaperCom.setBackgroundResource(0)
                            disableGame()
                            dialogGame()
                            ivCensor.visibility = View.GONE
                            bindingResultBinding.tvResult.setText(R.string.result_win_two)
                        }
                }
                ivRockCom.setOnClickListener {
                    ivRockCom.setBackgroundResource(R.drawable.bg_suit).also {
                            Log.d("Comp-Rock", "Computer picked rock")
                            ivResult.setImageResource(R.drawable.img_menang)
                            ivScissorCom.setBackgroundResource(0)
                            ivPaperCom.setBackgroundResource(0)
                            disableGame()
                            dialogGame()
                            ivCensor.visibility = View.GONE
                            bindingResultBinding.tvResult.text = buildString {
                                append("$nameLogin\nMENANG!")
                            }
                        }
                }
                ivPaperCom.setOnClickListener {
                    ivPaperCom.setBackgroundResource(R.drawable.bg_suit).also {
                            Log.d("Comp-Paper", "Computer picked paper")
                            ivResult.setImageResource(R.drawable.img_draw)
                            ivRockCom.setBackgroundResource(0)
                            ivScissorCom.setBackgroundResource(0)
                            disableGame()
                            dialogGame()
                            ivCensor.visibility = View.GONE
                            bindingResultBinding.tvResult.setText(R.string.result_draw)
                        }
                }
            }
        }

    }

    //For Sound on click. Untuk efek suara pada onClick.
    private fun sound() {
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.sound_pop)
        mediaPlayer.start()
        vibratePhone()
    }

    //For Vibration on click. Untuk efek vibrasi pada onClick.
    private fun Activity.vibratePhone() {
        val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
    }

    //Display dialog on back pressed. Menampilkan Dialog saat on back pressed.
    override fun onBackPressed() {
        bindingDialog = DialogViewBinding.inflate(layoutInflater)
        val view = bindingDialog.root
        val builder = AlertDialog.Builder(this@PvpActivity)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        bindingDialog.btnBack.setOnClickListener { dialog.hide() }
        bindingDialog.btnExit.setOnClickListener { finish() }
    }

    //Dialog of the game results.
    private fun dialogGame() {
        bindingResultBinding = DialogResultBinding.inflate(layoutInflater)
        val view = bindingResultBinding.root
        val builder = AlertDialog.Builder(this@PvpActivity)
        builder.setView(view)

        //val intentThis:Intent = (this@MainActivity)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        //Button Kembali ke menu
        bindingResultBinding.btnBack.setOnClickListener {
            val intentMain = Intent(this@PvpActivity, MenuActivity::class.java)
            intentMain.putExtra("name", nameLogin)
            startActivity(intentMain)
            finishAffinity()
        }
        //Button Main lagi
        bindingResultBinding.btnExit.setOnClickListener {
            dialog.hide()
            binding.apply {
                ivRockPlayer.apply { setBackgroundResource(0) }.apply { isClickable = true }
                ivPlayerScissor.apply { setBackgroundResource(0) }.apply { isClickable = true }
                ivPaperPlayer.apply { setBackgroundResource(0) }.apply { isClickable = true }
                ivRockCom.setBackgroundResource(0)
                ivScissorCom.setBackgroundResource(0)
                ivPaperCom.setBackgroundResource(0)
                ivResult.setImageResource(R.drawable.img_vs)
            }
        }
    }
}

