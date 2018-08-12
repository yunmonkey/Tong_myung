package com.example.taeandroid.studycustomlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var list = ArrayList<HashMap<String, Any>>()

    var album = intArrayOf(R.drawable.hu_gak_icon, R.drawable.hu_gak_icon_two,
            R.drawable.image_mc_the_max, R.drawable.shown_icon, R.drawable.nilro_icon,
            R.drawable.cold_in_shake_icon)

    var singer = arrayOf("허각", "허각", "엠씨 더 맥스", "숀", "닐로", "슈퍼비")

    var song = arrayOf("사월의 눈", "나를 사랑했던 사람아", "어디에도", "Way back home", "지나오다",
            "냉탕에 상어")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var idx = 0

        while(idx < song.size){
            var map = HashMap<String, Any>()
            map.put("album", album[idx])
            map.put("singer", singer[idx])
            map.put("song" , song[idx])

            list.add(map)
            idx++
        }

        var keydata = arrayOf("album", "singer", "song")

        var data = intArrayOf(R.id.imageView, R.id.textView2, R.id.textView3)

        var adapter = SimpleAdapter(this, list, R.layout.musiclist, keydata, data)

        listView.adapter = adapter
    }
}
