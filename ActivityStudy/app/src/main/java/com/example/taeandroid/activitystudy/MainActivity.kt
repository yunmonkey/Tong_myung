package com.example.taeandroid.activitystudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {//액티비티 처음 실행될때 onCreate
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("abc","on create")
    }

    override fun onStart() {//onStart실행
        super.onStart()
        Log.d("abcd","onStart")
    }

    override fun onResume() {//액티비티 실행되거나 사라졌던것이 다시 보일때 무조건 onResume실행
        super.onResume()
        Log.d("abcd", "onResume")
    }

    override fun onRestart() {//홈키 눌러서 앱이 다시 실행될때 onRestart실행
        super.onRestart()
        Log.d("abcd", "onRestart")
    }

    override fun onStop() {//홈키 눌렀을때 onStop실행
        super.onStop()
        Log.d("abcd","onStop")
    }

    override fun onPause() {//알림창 때문에 앱이 가려졌거나 종료될때 무조건 onPause 실행
        super.onPause()
        Log.d("abcd", "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("abcd", "onDestory")
    }
}
