package com.example.taeandroid.radiocheckbox

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            when(group1.checkedRadioButtonId){
                R.id.radio1 -> textview.text = "라디오 버튼 1-1이 선택되었습니다."
                R.id.radio2 -> textview.text = "라디오 버튼 1-2가 선택되었습니다."
                R.id.radio3 -> textview.text = "라디오 버튼 1-3이 선택되었습니다."
            }

            when(group2.checkedRadioButtonId){
                R.id.radiobutton1 -> textview2.text = "라디오 버튼 2-1가 선택되었습니다."
                R.id.radiobutton2 -> textview2.text = "라디오 버튼 2-2가 선택되었습니다."
                R.id.radiobutton3 -> textview2.text = "라디오 버튼 2-3가 선택되었습니다."
            }
        }

        button2.setOnClickListener { view ->
            radiobutton2.isChecked = true
            radiobutton3.isChecked = true
        }

        /*var listener = RadioListener()
        group1.setOnCheckedChangeListener(listener)     //이너 클래스로 객체를만들어서 추가
        group2.setOnCheckedChangeListener(listener)*/

        group1.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.radio1 -> textview.text = "람다 이벤트 : 라디오 버튼 1-1가 선택되었습니다."
                R.id.radio2 -> textview.text = "람다 이벤트 : 라디오 버튼 1-2가 선택되었습니다."
                R.id.radio3 -> textview.text = "람다 이벤트 : 라디오 버튼 1-3가 선택되었습니다."
            }
        }
        group2.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.radiobutton1 -> textview2.text = "람다 이벤트 : 라디오 버튼 2-1가 선택되었습니다."
                R.id.radiobutton2 -> textview2.text = "람다 이벤트 : 라디오 버튼 2-2가 선택되었습니다."  //람다식 표현 첫번째 매개변수 그룹 id
                R.id.radiobutton3 -> textview2.text = "람다 이벤트 : 라디오 버튼 2-3가 선택되었습니다."  //두번째 매개변수 버튼 id
            }
        }
    }

    inner class RadioListener : RadioGroup.OnCheckedChangeListener{
        override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
            when(p0?.id){
                R.id.group1 -> when(p1){
                    R.id.radio1 -> textview.text = "라디오 버튼 1-1가 선택되었습니다."
                    R.id.radio2 -> textview.text = "라디오 버튼 1-2가 선택되었습니다."
                    R.id.radio3 -> textview.text = "라디오 버튼 1-3가 선택되었습니다."
                }

                R.id.group2 -> when(p1){
                    R.id.radiobutton1 -> textview2.text = "라디오 버튼 2-1가 선택되었습니다."
                    R.id.radiobutton2 -> textview2.text = "라디오 버튼 2-2가 선택되었습니다."
                    R.id.radiobutton3 -> textview2.text = "라디오 버튼 2-3가 선택되었습니다."
                }
            }

        }

    }
}
