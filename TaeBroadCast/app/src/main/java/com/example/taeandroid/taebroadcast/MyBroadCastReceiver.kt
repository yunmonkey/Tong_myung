package com.example.taeandroid.taebroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadCastReceiver : BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {

        when(p1?.action){
            Intent.ACTION_BOOT_COMPLETED -> p0?.startActivity(Intent(p0, MainActivity::class.java))
            Intent.ACTION_BATTERY_LOW ->
                    Toast.makeText(p0, "배터리가 없습니다", Toast.LENGTH_SHORT).show()
            "android.net.conn.CONNECTIVITY_CHANGE" ->
                Toast.makeText(p0, "네트워크 상태가 변경 되었습니다.", Toast.LENGTH_SHORT).show()
            "android.provider.Telephony.SMS_RECEIVED" ->
                Toast.makeText(p0, "문자가 도착했습니다", Toast.LENGTH_SHORT).show()
            Intent.ACTION_DATE_CHANGED ->
                Toast.makeText(p0, "날짜가 변경되었습니다.", Toast.LENGTH_SHORT).show()
            Intent.ACTION_TIME_TICK ->
                Toast.makeText(p0, "분이 변경되어습니다.", Toast.LENGTH_SHORT).show()
            Intent.ACTION_AIRPLANE_MODE_CHANGED ->
                Toast.makeText(p0, "비행기 모드로 전환 됩니다.", Toast.LENGTH_SHORT).show()
            Intent.ACTION_CAMERA_BUTTON ->
                Toast.makeText(p0, "카메라 버튼을 클릭하였습니다.", Toast.LENGTH_SHORT).show()
        }
    }
}