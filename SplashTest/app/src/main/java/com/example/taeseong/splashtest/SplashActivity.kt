package com.example.taeseong.splashtest

import android.app.Activity
import android.content.Intent
import android.os.Bundle

/**
 * Created by Taeseong on 2018-09-02.
 */
class SplashActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            Thread.sleep(4000)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}