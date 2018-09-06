package com.example.taeseong.firebasefirestoreget

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var gongjiDTO = GonjiDTO("공지1" ,"테스터 앱이 개발 되었습니다.", "윤태성")

        var arrayList = arrayListOf<GonjiDTO>()
        arrayList.add(gongjiDTO)



        FirebaseFirestore.getInstance().collection("notice").get().addOnSuccessListener { querySnapshot ->
            for(item in querySnapshot.documents){
                var notice = item.toObject(GonjiDTO::class.java)
                arrayList.add(notice)
            }
            recyclerView_notice.adapter = ReadRecyclerViewAdapter(arrayList)
            recyclerView_notice.layoutManager = LinearLayoutManager(this)
        }
    }
    class ReadRecyclerViewAdapter(initlist: ArrayList<GonjiDTO>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        var list: ArrayList<GonjiDTO>? = initlist
        override fun getItemCount(): Int {
            return list!!.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_date,parent,false)
            return CustomViewHolder(view)
        }

        class CustomViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
            var textview_date = view?.findViewById<TextView>(R.id.dateText)
            var textview_notice = view?.findViewById<TextView>(R.id.notice)
            var textview_user = view?.findViewById<TextView>(R.id.nameText)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var customViewHolder = holder as CustomViewHolder
            customViewHolder.textview_date!!.text = list?.get(position)?.date
            customViewHolder.textview_notice!!.text = list?.get(position)?.notice
            customViewHolder.textview_user!!.text = list?.get(position)?.user
        }

    }
}
