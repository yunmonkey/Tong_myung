package com.example.taeandroid.toast

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toast.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button1.setOnClickListener { view ->
            var text = Toast.makeText(this, "토스트 메세지 입니다.",Toast.LENGTH_SHORT)
            text.show()
        }

        button2.setOnClickListener { view ->
            var v1 = layoutInflater.inflate(R.layout.custom_toast, null)


            v1.setBackgroundResource(android.R.drawable.toast_frame)

            var image_view: ImageView? = v1.findViewById<ImageView>(R.id.imageview)
            image_view?.setImageResource(R.drawable.android)

            var text_view: TextView? = v1.findViewById<TextView?>(R.id.textView3)

            text_view?.text = "커스텀 토스트 메세지"
            text_view?.setTextColor(Color.WHITE)
            var t2 = Toast(this)
            t2.view = v1

            t2.setGravity(Gravity.CENTER,0 , 0)
            t2.show()
        }
    }
}
