package com.example.taeandroid.viewpagerex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var view_list = ArrayList<View>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_list.add(layoutInflater.inflate(R.layout.view1,null))
        view_list.add(layoutInflater.inflate(R.layout.view2,null))
        view_list.add(layoutInflater.inflate(R.layout.view3,null))

        Pager.adapter = CustomeAdapter()
        Pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
//            스크롤 상태가 변경되었을때 이용되는 리스너
            override fun onPageScrollStateChanged(state: Int) {

            }

//            첫번째 매개변수 인덱스 번호  페이지가 넘어갈때 사용되는 리스너
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                textView.text = "${position} 번째  뷰가 나타났습니다."
            }


//            말그대로 페이지를 선택했을때 클릭하면 반응하는 친구
            override fun onPageSelected(position: Int) {

            }
        })
    }

    inner class CustomeAdapter : PagerAdapter(){
//        현재 객체가 보여줄 객체와 일치하는지 구분하는것 첫번째는 보여줄 뷰 객체 두번째는 많은 객체들이 들어온다.
//        즉 만들어진 뷰 객체가 현재 보여줄 뷰 객체가 일치하는지 점검하는 메소드
        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

//         뷰 페이저로 보여지는 뷰의 갯수를 반환하는 메소드
        override fun getCount(): Int {
            return view_list.size
        }

//        가장 중요한 메소드
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            Pager.addView(view_list[position])

            return view_list[position]
        }

//        이게 없으면 정상 작동 안됨
        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

            Pager.removeView(`object` as View)
        }
    }
}
