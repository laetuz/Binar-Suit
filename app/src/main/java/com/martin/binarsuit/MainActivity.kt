package com.martin.binarsuit

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var ivRock: ImageView
    lateinit var ivScissor: ImageView
    lateinit var ivPaper: ImageView

    lateinit var ivRockCom: ImageView
    lateinit var ivScissorCom: ImageView
    lateinit var ivPaperCom: ImageView

    lateinit var ivResult: ImageView
    lateinit var ivRefresh: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpView()
        setUpAction()
        clearGame()
    }


    fun setUpView() {
        ivRock = findViewById(R.id.iv_rock_player)
        ivScissor = findViewById(R.id.iv_player_scissor)
        ivPaper = findViewById(R.id.iv_paper_player)

        ivRockCom = findViewById(R.id.iv_rock_com)
        ivScissorCom = findViewById(R.id.iv_scissor_com)
        ivPaperCom = findViewById(R.id.iv_paper_com)

        ivResult = findViewById(R.id.iv_result)
        ivRefresh = findViewById(R.id.iv_refresh)
    }

    fun setUpAction() {
        batuGame()
        guntingGame()
        kertasGame()
    }

    fun clearGame() {
        ivRefresh.setOnClickListener {
            ivRock.setBackgroundResource(0)
            ivScissor.setBackgroundResource(0)
            ivPaper.setBackgroundResource(0)
            ivRockCom.setBackgroundResource(0)
            ivScissorCom.setBackgroundResource(0)
            ivPaperCom.setBackgroundResource(0)
            ivResult.setImageResource(R.drawable.img_vs)
        }
    }

    fun batuGame() {
        ivRock.setOnClickListener {
            ivRock.setBackgroundResource(R.drawable.bg_suit)
            ivScissor.setBackgroundResource(0)
            ivPaper.setBackgroundResource(0)
            when ((1..3).random()) {
                1 -> {
                    ivScissorCom.setBackgroundResource(R.drawable.bg_suit)
                    ivResult.setImageResource(R.drawable.img_menang)
                    ivRockCom.setBackgroundResource(0)
                    ivPaperCom.setBackgroundResource(0)
                }
                2 -> {
                    ivRockCom.setBackgroundResource(R.drawable.bg_suit)
                    ivResult.setImageResource(R.drawable.img_draw)
                    ivScissorCom.setBackgroundResource(0)
                    ivPaperCom.setBackgroundResource(0)
                }
                else -> ivPaperCom.setBackgroundResource(R.drawable.bg_suit)
                    .also {
                        ivResult.setImageResource(R.drawable.img_menang2)
                        ivRockCom.setBackgroundResource(0)
                        ivScissorCom.setBackgroundResource(0)
                    }
            }
        }
    }

    fun guntingGame() {
        ivScissor.setOnClickListener {
            ivScissor.setBackgroundResource(R.drawable.bg_suit)
            ivRock.setBackgroundResource(0)
            ivPaper.setBackgroundResource(0)
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

    fun kertasGame() {
        ivPaper.setOnClickListener {
            ivPaper.setBackgroundResource(R.drawable.bg_suit)
            ivRock.setBackgroundResource(0)
            ivScissor.setBackgroundResource(0)
            when ((1..3).random()) {
                1 -> ivScissorCom.setBackgroundResource(R.drawable.bg_suit)
                    .also { ivResult.setImageResource(R.drawable.img_menang2) }
                2 -> ivRockCom.setBackgroundResource(R.drawable.bg_suit)
                    .also { ivResult.setImageResource(R.drawable.img_menang) }
                else -> ivPaperCom.setBackgroundResource(R.drawable.bg_suit)
                    .also { ivResult.setImageResource(R.drawable.img_draw) }
            }

        }
    }
}

