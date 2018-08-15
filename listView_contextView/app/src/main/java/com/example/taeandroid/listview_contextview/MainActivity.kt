package com.example.taeandroid.listview_contextview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row1.*

class MainActivity : AppCompatActivity() {

    var list = ArrayList<HashMap<String,Any>>()
    var img = intArrayOf(R.drawable.taeseong_yun_icon, R.drawable.seokwon_icon, R.drawable.woochan_kim_icon,
            R.drawable.youngwook_kim_icon, R.drawable.minji_hoon_icon, R.drawable.son_hee_icon)
    var name = arrayOf("나", "정석원", "김우찬", "김영욱", "민지훈", "손용희")
    var text = arrayOf("메모장 쓰기", "석그로 입니다.", "우레벌떡", "전역했습니다.",
            "블라디 하면 다이긴다", "원챔 재미없다")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var idx = 0
        while(idx < name.size){
            var map = HashMap<String, Any>()
            map.put("profile_img", img[idx])
            map.put("my_name", name[idx])
            map.put("my_text", text[idx])

            list.add(map)
            idx++
        }

        var keys = arrayOf("profile_img", "my_name", "my_text")
        var ids = intArrayOf(R.id.imageView5, R.id.textView1, R.id.textView3)
        var adapter = SimpleAdapter(this, list, R.layout.row1, keys, ids)

        listView.adapter = adapter


        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        var info = menuInfo as AdapterView.AdapterContextMenuInfo
        when(v?.id){
            R.id.listView ->{
                menu?.setHeaderTitle(name[info.position])
                menuInflater.inflate(R.menu.context_view, menu)
            }
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }


//    override fun onContextItemSelected(item: MenuItem?): Boolean {
//        when(item?.itemId){
//
//        }
//        return super.onContextItemSelected(item)
//    }
}
