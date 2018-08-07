package com.example.taeandroid.toaststudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener{
    override fun onClick(p0: View?) {
        if(p0 == button_ok)
            showText("이름이 저장되었습니다.")
        else if(p0 == button_cancle){
            showText("취소 되었습니다.")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_ok.text = "확인"
        button_cancle.text = "취소"
        input_name.hint = "이름을 입력하세요"
        input_phone.hint = "전화번호를 입력하세요"
        button_ok.setOnClickListener(this)
        button_cancle.setOnClickListener(this)
    }

    fun showText(msg: String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}
