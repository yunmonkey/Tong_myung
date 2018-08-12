package com.example.taeandroid.customadapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.InflateException
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data = arrayOf("data1","data2","data3","data4","data5","data6")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var adapter = ArrayAdapter<String>(this,R.layout.row, R.id.textView2, data)
        var adapter = ListAdapter()
        listView.adapter = adapter
    }

    inner class ListAdapter : BaseAdapter(){  //getView 메소드와 getCount 메소드가 가장 많이 쓰임
        //        getView 메소드가 가장 많이 쓰임
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? { //첫번째 매개변수로 들어온 p0가 항목의 인덱스 번호
            var convertView: View?  = p1 //재사용 가능한 뷰가 p1 으로 넘어오게 되는데 재사용 가능한 뷰가 들어오지 않으면 null값이 되므로
//             밑에 if 문으로 들어가 뷰를 객체화 시켜 다시 만들어 준다.

            var listener = BtnListener()
            if(p1 == null){
                convertView = layoutInflater.inflate(R.layout.row, null) //layoutInflater 는 xml 파일을 (뷰)객체화 해주는 클래스 뒤에 null값은 잘 모르겠음
            }


            var text: TextView? = convertView?.findViewById<TextView?>(R.id.textView2)
            var button1: Button? = convertView?.findViewById<Button?>(R.id.button)
            var button2: Button? = convertView?.findViewById<Button?>(R.id.button2)

            button1?.tag = p0//각각 버튼 객체에 항목의 인덱스번호를 저장
            button2?.tag = p0

            text?.text = data[p0]
            button1?.setOnClickListener(listener)
            button2?.setOnClickListener(listener)
            return convertView
        }

        //이 메소드가 반환하는 갯수로 리스트뷰의 항목의 갯수로 결정됨
        override fun getCount(): Int {
            return data.size
        }

        //매개변수로 들어올때는 객체로 반환하는건데 필요없을때는 null 반환
        override fun getItem(p0: Int): Any? {
            return null
        }

        //항목을 대표하는 id 값을 반환
        override fun getItemId(p0: Int): Long {
            return 0
        }

    }
    inner class BtnListener : View.OnClickListener{

        override fun onClick(p0: View?) {
            var position = p0?.tag
            when(p0?.id){

                R.id.button ->
                    textView.text = "${position} : 첫번째 버튼이 선택되었습니다."
                R.id.button2 ->
                    textView.text = "${position} : 두 번째 버튼이 선택되었습니다."

            }
        }

    }
}
