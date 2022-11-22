package com.martin.binarsuit

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var batu: ImageView
    lateinit var gunting: ImageView
    lateinit var kertas: ImageView

    lateinit var batuCom: ImageView
    lateinit var guntingCom: ImageView
    lateinit var kertasCom: ImageView

    lateinit var tvVS: ImageView
    lateinit var imgRefresh: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpView()
        setUpAction()
        clearGame()
    }


    fun setUpView() {
        batu = findViewById(R.id.imgPlayerBatu)
        gunting = findViewById(R.id.imgPlayerGunting)
        kertas = findViewById(R.id.imgPlayerKertas)

        batuCom = findViewById(R.id.imgComBatu)
        guntingCom = findViewById(R.id.imgComGunting)
        kertasCom = findViewById(R.id.imgComKertas)

        tvVS = findViewById(R.id.tvVS)
        imgRefresh = findViewById(R.id.img_refresh)
    }

    fun setUpAction() {
        batuGame()
        guntingGame()
        kertasGame()
    }

    fun clearGame() {
        imgRefresh.setOnClickListener {
            batu.setBackgroundResource(0)
            gunting.setBackgroundResource(0)
            kertas.setBackgroundResource(0)
            batuCom.setBackgroundResource(0)
            guntingCom.setBackgroundResource(0)
            kertasCom.setBackgroundResource(0)
            tvVS.setImageResource(R.drawable.img_vs)
        }
    }

    fun batuGame() {
        batu.setOnClickListener {
            batu.setBackgroundResource(R.drawable.bg_suit)
            gunting.setBackgroundResource(0)
            kertas.setBackgroundResource(0)
            when ((1..3).random()) {
                1 -> {
                    guntingCom.setBackgroundResource(R.drawable.bg_suit)
                    tvVS.setImageResource(R.drawable.img_menang)
                    batuCom.setBackgroundResource(0)
                    kertasCom.setBackgroundResource(0)
                }
                2 -> {
                    batuCom.setBackgroundResource(R.drawable.bg_suit)
                    tvVS.setImageResource(R.drawable.img_draw)
                    guntingCom.setBackgroundResource(0)
                    kertasCom.setBackgroundResource(0)
                }
                /*batuCom.setImageResource(R.drawable.batu_selected)
                    .also {
                        tvVS.setImageResource(R.drawable.img_draw)
                        guntingCom.setBackgroundResource(0)
                        kertasCom.setBackgroundResource(0)
                    }*/
                else -> kertasCom.setBackgroundResource(R.drawable.bg_suit)
                    .also {
                        tvVS.setImageResource(R.drawable.img_menang2)
                        batuCom.setBackgroundResource(0)
                        guntingCom.setBackgroundResource(0)
                    }
            }
        }
    }

    fun guntingGame() {
        gunting.setOnClickListener {
            gunting.setBackgroundResource(R.drawable.bg_suit)
            batu.setBackgroundResource(0)
            kertas.setBackgroundResource(0)
            when ((1..3).random()) {
                1 -> guntingCom.setBackgroundResource(R.drawable.bg_suit)
                    .also {
                        tvVS.setImageResource(R.drawable.img_draw)
                        batuCom.setBackgroundResource(0)
                        kertasCom.setBackgroundResource(0)
                    }
                2 -> batuCom.setBackgroundResource(R.drawable.bg_suit)
                    .also {
                        tvVS.setImageResource(R.drawable.img_menang2)
                        guntingCom.setBackgroundResource(0)
                        kertasCom.setBackgroundResource(0)
                    }
                else -> kertasCom.setBackgroundResource(R.drawable.bg_suit)
                    .also {
                        tvVS.setImageResource(R.drawable.img_menang)
                        batuCom.setBackgroundResource(0)
                        guntingCom.setBackgroundResource(0)
                    }
            }
        }
    }

    fun kertasGame() {
        kertas.setOnClickListener {
            kertas.setBackgroundResource(R.drawable.bg_suit)
            batu.setBackgroundResource(0)
            gunting.setBackgroundResource(0)
            when ((1..3).random()) {
                1 -> guntingCom.setBackgroundResource(R.drawable.bg_suit)
                    .also { tvVS.setImageResource(R.drawable.img_menang2) }
                2 -> batuCom.setBackgroundResource(R.drawable.bg_suit)
                    .also { tvVS.setImageResource(R.drawable.img_menang) }
                else -> kertasCom.setBackgroundResource(R.drawable.bg_suit)
                    .also { tvVS.setImageResource(R.drawable.img_draw) }
            }

        }
    }
}

