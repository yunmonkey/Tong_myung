package com.example.taeandroid.seekbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener { view ->
            textview.text = "seek1 : ${seekbar1.progress}"
            textview2.text = "seek2 : ${seekBar2.progress}"
        }

        button2.setOnClickListener { view ->
            seekbar1.incrementProgressBy(1)
            seekBar2.incrementProgressBy(1)
        }
        button3.setOnClickListener{ view ->
            seekbar1.incrementProgressBy(-1)
            seekBar2.incrementProgressBy(-1)
        }

        var listener = SeekbarListener()
        seekbar1.setOnSeekBarChangeListener(listener)

        seekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                textview2.text = "seek2 : ${p1}"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {



            }

            override fun onStopTrackingTouch(p0: SeekBar?) {



            }
        })//오버라이딩이 여러개 있는 메소드는 바로 람다식 쓸수가 없고 이렇게 익명 중첩 클래스로 인해 만들어 줘야한다.
    }

    inner class SeekbarListener : SeekBar.OnSeekBarChangeListener{
        //seekbar 값이 변경되었을때    첫번째 매개변수 시크바id , 두번째 매개변수 현재 설정된 값, 세번째 사용자가 터치해서 값 바꾸면 true
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            textview.text = "seek1 : ${p1}"
        }

        //seekbar 값을 변경하기 위해 사용자가 bar를 터치하였을
        override fun onStartTrackingTouch(p0: SeekBar?) {

        }

        //값을 변경후 터치를 땟을때
        override fun onStopTrackingTouch(p0: SeekBar?) {

        }

    }
}
