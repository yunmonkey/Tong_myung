package com.example.taeandroid.spinnerstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var data1 = arrayOf("데이터1-1", "데이터1-2", "데이터1-3" ,"데이터1-4", "데이터1-5")
    var data2 = arrayOf("데이터2-1", "데이터2-2", "데이터2-3" ,"데이터2-4", "데이터2-5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data1)
        var adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data2)

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter1
        spinner2.adapter = adapter2

        var listner = SpinnerListner()
        spinner.onItemSelectedListener = listner

        button.setOnClickListener { view ->
            textView.text = data1[spinner.selectedItemPosition]
        }
//        오버라이드 되는 함수가 2개가 있으므로 람다식 구현 안됨 따라서 익명 중첩 클래스로
//        object 클래스 만들어서 바로 객체 생성 해주었음.
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                textView2.text = data2[p2]
            }

        }
    }

    inner class SpinnerListner : AdapterView.OnItemSelectedListener{
//        선택됬을때 발생하는 리스너 p2 가 인덱스 번호
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            textView.text = data1[p2]
        }
//        아무것도 선택되지 않았을때 발생하는 리스너 사용하지 않음
        override fun onNothingSelected(p0: AdapterView<*>?) {

        }


    }
}
