package com.example.taeandroid.study

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() , View.OnClickListener{

    var trueBtn : Button? = null
    var falseBtn : Button? = null
    var textView : TextView? = null

    override fun onClick(p0: View?) {
        if(p0 == trueBtn){
            textView?.visibility = View.VISIBLE
        } else if(p0==falseBtn){
            textView?.visibility = View.INVISIBLE
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueBtn = findViewById(R.id.btn1)
        textView = findViewById(R.id.textView)
        falseBtn = findViewById(R.id.btn2)

        trueBtn?.setOnClickListener(this)
        falseBtn?.setOnClickListener(this)



    }

}
