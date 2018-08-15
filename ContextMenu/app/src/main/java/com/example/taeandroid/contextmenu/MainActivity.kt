package com.example.taeandroid.contextmenu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var list = ArrayList<HashMap<String,String>>()

    var menu_num = arrayOf("메뉴1", "메뉴2" , "메뉴3", "메뉴4", "메뉴5", "메뉴6", "메뉴7")
    var menu_what = arrayOf("손님1","손님2","손님3","손님4","손님5","손님6","손님7" )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var idx = 0

        while (idx < menu_num.size) {
            var map = HashMap<String, String>()
            map.put("menu_num", menu_num[idx])
            map.put("menu_what", menu_what[idx])

            list.add(map)
            idx++
        }
        var keys = arrayOf("menu_num", "menu_what")
        var ids = intArrayOf(R.id.rowTextView, R.id.rowTextView2)
        var adapter = SimpleAdapter(this, list, R.layout.row, keys, ids)

        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            textView.text = "${i} 번째 항목을 터치 했습니다."
        }
        registerForContextMenu(textView)
        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        when(v?.id){
            R.id.textView -> {
                menu?.setHeaderTitle("텍스트 뷰의 메뉴")
                menuInflater.inflate(R.menu.contextmenu,menu)
            }
            R.id.listView -> {
                menu?.setHeaderTitle("메뉴를 정하세요")
                menuInflater.inflate(R.menu.listview_menu, menu)
                var info = menuInfo as AdapterView.AdapterContextMenuInfo
//                info.position  //이렇게 해주면 사용자가 길게누른 인덱스 번호가 주어진다.
                if(info.position % 2 == 0){
                    menu?.add(Menu.NONE , Menu.FIRST +1, Menu.NONE , "리스트뷰의 메뉴 3")
                }
            }
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        var position = listView.tag
        when(item?.itemId){
            R.id.textView_item1 ->
                textView.text = "컨텍스트 메뉴 1번이 선택되었습니다."
            R.id.textView_item2 ->
                textView.text = "컨텍스트 메뉴 2번이 선택되었습니다."
            R.id.textView_item3 ->{
                textView.text = "리스트뷰의 컨텍스트 메뉴 1"
                var info = item?.menuInfo as AdapterView.AdapterContextMenuInfo
                textView.append("${info.position} 번째 항목")
            }

            R.id.textView_item4 -> {
                textView.text = "리스트뷰의 컨텍스트 메뉴2"
                var info = item?.menuInfo as AdapterView.AdapterContextMenuInfo
                textView.append("${info.position} 번째 항목")
            }

        }
        return super.onContextItemSelected(item)
    }

}
