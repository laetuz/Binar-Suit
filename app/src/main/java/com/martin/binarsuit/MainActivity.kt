package com.martin.binarsuit

import android.app.Activity
import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.martin.binarsuit.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view) // 1. View ViewBinding components, UI logic
        setUpAction() // 2. Calling game logic
        clearGame() // 3. Clearing the game logic from the UI logic
    }

    //Main logic for the game
    private fun setUpAction() {
        rockGame()
        scissorGame()
        paperGame()
    }

    //Called if refresh button is clicked
    private fun clearGame() {
        binding.apply {
            ivRefresh.setOnClickListener {
                sound()
                ivRockPlayer.setBackgroundResource(0)
                ivPlayerScissor.setBackgroundResource(0)
                ivPaperPlayer.setBackgroundResource(0)
                ivRockCom.setBackgroundResource(0)
                ivScissorCom.setBackgroundResource(0)
                ivPaperCom.setBackgroundResource(0)
                ivResult.setImageResource(R.drawable.img_vs)
            }

            ivRefresh.setOnLongClickListener {
                finish()
                startActivity(intent)
                true
            }
        }

    }

    //Called if player picked rock
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
                when ((1..3).random()) {
                    1 -> {
                        Log.d("ComSci", "Computer memilih gunting")
                        ivScissorCom.setBackgroundResource(R.drawable.bg_suit)

                        ivResult.setImageResource(R.drawable.img_menang)
                        ivRockCom.setBackgroundResource(0)
                        ivPaperCom.setBackgroundResource(0)
                    }
                    2 -> {
                        Log.d("ComRock", "Computer memilih batu")
                        ivRockCom.setBackgroundResource(R.drawable.bg_suit)
                        ivResult.setImageResource(R.drawable.img_draw)
                        ivScissorCom.setBackgroundResource(0)
                        ivPaperCom.setBackgroundResource(0)
                    }
                    else -> ivPaperCom.setBackgroundResource(R.drawable.bg_suit)
                        .also {
                            Log.d("ComPaper", "Computer memilih kertas")
                            ivResult.setImageResource(R.drawable.img_menang2)
                            ivRockCom.setBackgroundResource(0)
                            ivScissorCom.setBackgroundResource(0)
                        }
                }
            }
        }

    }

    //Called if player picked scissor
    private fun scissorGame() {
        binding.apply {
            ivPlayerScissor.setOnClickListener {
                sound()
                ivPlayerScissor.setBackgroundResource(R.drawable.bg_suit)
                ivRockPlayer.setBackgroundResource(0)
                ivPaperPlayer.setBackgroundResource(0)
                ivResult.animate().apply {
                    duration = 200
                    rotationBy(360f)
                }.start()
                when ((1..3).random()) {
                    1 -> ivScissorCom.setBackgroundResource(R.drawable.bg_suit)
                        .also {
                            ivResult.setImageResource(R.drawable.img_draw)
                            ivRockCom.setBackgroundResource(0)
                            ivPaperCom.setBackgroundResource(0)
                        }
                    2 -> ivRockCom.setBackgroundResource(R.drawable.bg_suit)
                        .also {
                            ivResult.setImageResource(R.drawable.img_menang2)
                            ivScissorCom.setBackgroundResource(0)
                            ivPaperCom.setBackgroundResource(0)
                        }
                    else -> ivPaperCom.setBackgroundResource(R.drawable.bg_suit)
                        .also {
                            ivResult.setImageResource(R.drawable.img_menang)
                            ivRockCom.setBackgroundResource(0)
                            ivScissorCom.setBackgroundResource(0)
                        }
                }
            }
        }

    }

    //Called if player picked paper
    private fun paperGame() {
        binding.apply {
            ivPaperPlayer.setOnClickListener {
                sound()
                ivPaperPlayer.setBackgroundResource(R.drawable.bg_suit)
                ivRockPlayer.setBackgroundResource(0)
                ivPlayerScissor.setBackgroundResource(0)
                ivResult.animate().apply {
                    duration = 200
                    rotationBy(360f)
                }.start()
                when ((1..3).random()) {
                    1 -> ivScissorCom.setBackgroundResource(R.drawable.bg_suit)
                        .also {
                            ivResult.setImageResource(R.drawable.img_menang2)
                            ivRockCom.setBackgroundResource(0)
                            ivPaperCom.setBackgroundResource(0)
                        }
                    2 -> ivRockCom.setBackgroundResource(R.drawable.bg_suit)
                        .also {
                            ivResult.setImageResource(R.drawable.img_menang)
                            ivScissorCom.setBackgroundResource(0)
                            ivPaperCom.setBackgroundResource(0)
                        }
                    else -> ivPaperCom.setBackgroundResource(R.drawable.bg_suit)
                        .also {
                            ivResult.setImageResource(R.drawable.img_draw)
                            ivRockCom.setBackgroundResource(0)
                            ivScissorCom.setBackgroundResource(0)
                        }
                }

            }
        }

    }

    //For Sound on click
    private fun sound() {
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.sound_pop)
        mediaPlayer.start()
        vibratePhone()
    }

    //For Vibration on click
    private fun Activity.vibratePhone() {
        val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
    }
}

