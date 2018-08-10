package com.example.taeandroid.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data = arrayOf("", "", "", "", "", "", "", "", "", "", "", "")//바로 값을 넣어줘도 되는데 밑에 포문으로 인덱스에 접근해서 다시 넣어주었다

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(i in data.indices)
            data[i] = "리스트${i+1}"

        var adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1,data) //ArrayAdapter 객체를 사용
        //첫번째 매개변수는 Activity가 있는곳을 넣어주고 두번째는 어떻게 나열할건지 세번째는 데이터값

        listView.adapter = adapter1 //주요 프로퍼티 인데 리스트 뷰를 구성하기 위해 어뎁터 뷰 객체를 넣어주었음

        /*var listener = ListListener()
        listView.setOnItemClickListener(listener)*/

        listView.setOnItemClickListener { adapterView, view, i, l ->
            textview.text = data[i]
        }
    }

    inner class ListListener : AdapterView.OnItemClickListener{
        override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            textview.text = data[p2]
        }
    }
}
