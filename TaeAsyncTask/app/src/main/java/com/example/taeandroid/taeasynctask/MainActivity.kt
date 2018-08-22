package com.example.taeandroid.taeasynctask

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        AsyncTask만들때 object로 바로 객체 생성 해주고 AsyncTask의 매개변수
//        첫번째 값은 첫번째 값 두번째 값은 중간값 마지막값은 마지막에 출력되는 값이다
        var asyncTask = object : AsyncTask<Int, Int, String>(){

//            백그라운드로 값이 연산되는 부분
            override fun doInBackground(vararg p0: Int?): String {
                var position = p0[0]!!
                while(position < 100){
                    Thread.sleep(1000) //1초 동안재우고
                    position += 1 // 포지션에다가 1씩 추가 해주고
                    publishProgress(position)  //퍼플리쉬프로그래서는 onProgressUpdate한테 보고해주는 것이다.
                }
                return "다운로드가 끝났습니다."  //이 리턴값은 밑에 onPostExcetue로 리턴되어 전달된다.
            }

//            최종값이 출력되는 부분
            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                textView_main.setText(result)
            }

//           중간 값이 출력되는 부분
            override fun onProgressUpdate(vararg values: Int?) {
                super.onProgressUpdate(*values)
                textView_main.text = "${values[0]} %"
            }

        }
        asyncTask.execute(20) //시작값을 20으로 설정
    }
}
