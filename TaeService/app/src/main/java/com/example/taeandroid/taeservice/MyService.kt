package com.example.taeandroid.taeservice

import android.app.Service
import android.content.Intent
import android.os.AsyncTask
import android.os.IBinder


class MyService : Service(){
    override fun onBind(p0: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //    서비스가 생성될때 작동
    override fun onCreate() {
        super.onCreate()
    }
    //서비스가 생성되기 직전에 작동
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread{
            run {
                while (true){
                    Thread.sleep(3000)
                    println("서비스가 실행 중 입니다.")
                }
            }
        }.start()
//        START_STICKY는  서비스가 어떠한 에러로 종료 되어도 진드기처럼 다시 살리겠다는 flag값
        return START_STICKY
    }
    // 서비스가 제거 될 때 작동
    override fun onDestroy() {
        super.onDestroy()
    }


}