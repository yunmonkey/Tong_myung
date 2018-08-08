package com.example.taeandroid.progressbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener{ view ->
            progressBar4.incrementProgressBy(5)
        }

        button2.setOnClickListener{ view ->
            progressBar4.incrementProgressBy(-5)
        }
        button3.setOnClickListener { view ->
            progressBar4.progress = 50
        }
    }
}
