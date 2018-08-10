package com.example.taeandroid.edittextstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener{ view ->
            textview.text = "${editview.text}"
        }

        button2.setOnClickListener { view ->
            editview.setText("문자열")
        }

        editview.setOnEditorActionListener { textView, i, keyEvent ->
            textview.text = editview.text
            false
        }

      /*  var editwatcher = Editwatcher()
        editview.addTextChangedListener(editwatcher)*/

        editview.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {


            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                textview.text = p0
                //p0매개변수 = 에디트 뷰에서 입력한 문자열
            }
        })
    }
    inner class EditListener : TextView.OnEditorActionListener{
        //첫번째 매개변수 에디트뷰 주소값
        override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
            textview.text = editview.getText()
            return true
        }

    }

    inner class Editwatcher : TextWatcher{
        //문자열 바뀌기전
        // 첫번째 매개변수가 에디트 택스트에 들어온 문자열
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


        }

        //문자열 바뀌고 난후
        override fun afterTextChanged(p0: Editable?) {


        }

        //문자가 바뀔때
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            textview.text = p0

        }
    }
}
