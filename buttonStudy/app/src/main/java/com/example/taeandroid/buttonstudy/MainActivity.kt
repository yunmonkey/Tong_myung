package com.example.taeandroid.buttonstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener { view ->
            textview.text = "첫번째 버튼이 선택되었습니다."//람다식으로 표현 view매개변수가 기본 클래스안에서의 p0가 된다.
        }

        var listener1 = linstener()//이너클래서 만든것을 프로퍼티 추가해서 객체 생성
        var linstener = View.OnClickListener { view ->
            when(view.id){
                R.id.button2 -> textview.text = "두번째 버튼이 선택되었습니다."//when형은 Int 형만 들어가게 된다 따라서 idㄹ로만 바로 접근이 안되고 R.id.접근할id 로 접근해줘야한다.
                R.id.button3 -> textview.text = "세번째 버튼이 선택되었습니다."
            }
        }

        button2.setOnClickListener(linstener)//linstener라는 프로퍼티를 만들어 표현식으로 리스너를 넣어주었다
        button3.setOnClickListener(linstener)//위에 표현식에 의해서 버튼을 클릭하면 OnClickListener 매개변수에 button의 id 가 전달된다.
        button4.setOnClickListener(listener1)
        button5.setOnClickListener(listener1)//이너 클래스 만들어서 객체를 생성후 대입
    }
    inner class linstener: View.OnClickListener{
        override fun onClick(p0: View?) {
            textview.text = "네 번째 버튼이 선택되었습니다."

            when(p0?.id){
                R.id.button4 -> textview.text = "네번째 버튼이 선택되었습니다."
                R.id.button5 -> textview.text = "마지막 버튼이 선택되었습니다."
            }
        }
    }
}
