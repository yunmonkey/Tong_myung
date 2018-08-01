package com.example.taeandroid.study

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Main2Activity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(p0: View?) {
//        if(p0 == btn_True)
//            text_viewer?.visibility = View.VISIBLE
//        else if(p0 == btn_False)
//            text_viewer?.visibility = View.INVISIBLE
    }
    var btn_True: Button? = null
    var text_viewer: TextView? = null
    var btn_False: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn_True = findViewById(R.id.btn_True)
        text_viewer = findViewById(R.id.textviewer)
        btn_False = findViewById(R.id.btn_False)


        btn_True?.setOnClickListener{

                btn_True -> text_viewer?.visibility = View.VISIBLE

        }
        btn_False?.setOnClickListener{

                btn_False -> text_viewer?.visibility = View.INVISIBLE

        }
    }

}
