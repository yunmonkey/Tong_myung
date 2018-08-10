/*
문자열 하나만 세팅할 경우에는 ArrayAdapter를 이용한다
ArrayAdapter(안드로이드가 제공하는 정렬방식 객체 정의방법) -> ArrayAdapter(this, android.R.layout.simple_list_item_1,data)
ArrayAdapter(개발자가 직접만든 정렬방식 객제 정의법) -> ArrayAdapter(this, R.layout.xml이름 , R.id.textviewid값 , data)
ArrayAdapter는 텍스트뷰 하나만 세팅 하기 위해 사용하는 어뎁터
 */

package com.example.taeandroid.customlistview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data = arrayOf("데이터1","데이터2","데이터3","데이터4","데이터5","데이터6")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,data)
        var adapter = ArrayAdapter(this, R.layout.row1, R.id.textView2, data)//안드로이드가 기본적으로 제공해주는 정렬방식이 아닌
        //개발자가 직접 정렬을 만들었으면 레이아웃의 파일 이름과 문자열 하나만 세팅 할거니 textview의 주소값이 필요하다
        listview.adapter = adapter

        listview.setOnItemClickListener { adapterView, view, i, l ->
            textview.text = data[i]
        }
    }
}
