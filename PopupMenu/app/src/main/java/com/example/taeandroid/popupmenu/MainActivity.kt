package com.example.taeandroid.popupmenu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            var popup = PopupMenu(this, textView)


            menuInflater.inflate(R.menu.popup_menu, popup.menu)

            var listener = MenuListener()

//            popup.setOnMenuItemClickListener(listener)

            popup.setOnMenuItemClickListener { menuItem ->
                when(menuItem.itemId){
                    R.id.item1 ->
                            textView.text = "메뉴 1번이 선택되었습니다."
                    R.id.item2 ->
                            textView.text = "메뉴 2번을 눌렀습니다."
                    R.id.item3 ->
                            textView.text = "메뉴 3번을 눌렀습니다."
                }
                true
            }

            popup.show()
        }


    }



    inner class MenuListener : PopupMenu.OnMenuItemClickListener{
        override fun onMenuItemClick(p0: MenuItem?): Boolean {
            when(p0?.itemId){
                R.id.item1 ->
                        textView.text = "메뉴 1번을 눌렀습니다."
                R.id.item2 ->
                        textView.text = "메뉴 2번을 눌렀습니다."
                R.id.item3 ->
                        textView.text = "메뉴 3번을 눌렀습니다."
            }
            return false
        }

    }

}
