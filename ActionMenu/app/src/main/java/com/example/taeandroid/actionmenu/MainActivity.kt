package com.example.taeandroid.actionmenu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        var searchItem: MenuItem? = menu?.findItem(R.id.item5)
        var searchView: SearchView = searchItem?.actionView as SearchView

        searchView.queryHint = "검색어를 입력 해주세요"


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.item1 ->
                    textView1.text = "메뉴1번을 눌렀습니다."
            R.id.item2 ->
                    textView1.text ="메뉴2번을 눌렀습니다."
            R.id.item3 ->
                    textView1.text = "메뉴3번을 눌렀습니다."
            R.id.item4 ->
                    textView1.text = "메뉴 4번을 눌렀습니다."
        }
        return super.onOptionsItemSelected(item)
    }
}
