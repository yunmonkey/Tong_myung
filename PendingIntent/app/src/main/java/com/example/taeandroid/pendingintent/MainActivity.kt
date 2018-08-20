package com.example.taeandroid.pendingintent

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_one.setOnClickListener { view ->
            var builder = getNotificationBuilder("pending", "pending intent")
            builder.setContentTitle("Notification 1")
            builder.setContentText("알림 메세지 입니다.")
            builder.setSmallIcon(android.R.drawable.ic_menu_camera)
            builder.setAutoCancel(true)

            var intent1 = Intent(this, TestActivity1::class.java)  //Intent 는 안드로이드 한테 나 이것 실행해주세요 라고 알려주는
//            클래스 이다.

            intent1.putExtra("data1","문자열 데이터 1")
            intent1.putExtra("data2",100)
            var pending1 = PendingIntent.getActivity(this, 10 , intent1 , PendingIntent.FLAG_UPDATE_CURRENT)
            builder.setContentIntent(pending1)


            var intent2 = Intent(this, TestActivity2::class.java)
            intent2.putExtra("data2", "TextActivity 실행")

            var pending2 = PendingIntent.getActivity(this, 100 , intent2, PendingIntent.FLAG_UPDATE_CURRENT)

            var builder2 = NotificationCompat.Action.Builder(android.R.drawable.ic_menu_compass, " Action1", pending2)
            var action2 = builder2.build()
            builder.addAction(action2)
            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

        button2.setOnClickListener { view ->
            var builder = getNotificationBuilder("pending", "pending intent")
            builder.setContentTitle("Notification 2")
            builder.setContentText("알림 메세지 2입니다.")
            builder.setSmallIcon(android.R.drawable.ic_menu_camera)
            builder.setAutoCancel(true)

            var intent1 = Intent(this, TestActivity2::class.java)  //Intent 는 안드로이드 한테 나 이것 실행해주세요 라고 알려주는
//            클래스 이다.

            intent1.putExtra("data1", "문자열 데이터 2") //데이터를 넣는 방법
            intent1.putExtra("data2", 200)

            var pending1 = PendingIntent.getActivity(this, 0 , intent1 , PendingIntent.FLAG_UPDATE_CURRENT)
//           위에 PendingIntent.FLAG_UPDATE_CURRENT 이것 안해주면 데이터 값이 제대로 전달이 안된다.
//            바로바로 붙혀주도록 하자!
            builder.setContentIntent(pending1)

            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20, notification)
        }

        button3.setOnClickListener { view ->
            var builder = getNotificationBuilder("pending", "pending intent")
            builder.setContentTitle("Notification 3")
            builder.setContentText("알림 메세지 3입니다.")
            builder.setSmallIcon(android.R.drawable.ic_menu_camera)
            builder.setAutoCancel(true)

            var intent1 = Intent(this, TestActivity1::class.java)  //Intent 는 안드로이드 한테 나 이것 실행해주세요 라고 알려주는
//            클래스 이다.


            intent1.putExtra("data1","문자열 데이터3")
            intent1.putExtra("data2",300)
            var pending1 = PendingIntent.getActivity(this, 30 , intent1 , PendingIntent.FLAG_UPDATE_CURRENT)
//            requestCode를 다르게 줘야 같은 액티비티를 띄우는 각기 다른 팬딩 인텐드 값이 다르게 나온다.
            builder.setContentIntent(pending1)

            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(30, notification)
        }
    }


    fun getNotificationBuilder(id: String, name: String) : NotificationCompat.Builder{
        var builder: NotificationCompat.Builder? = null
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            var channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)

            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this, id)

        } else{
            builder = NotificationCompat.Builder(this)
        }
        return builder
    }
}
