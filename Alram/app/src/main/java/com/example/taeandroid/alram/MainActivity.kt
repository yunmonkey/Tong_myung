package com.example.taeandroid.alram

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(p0: View?) {
        if(p0 == mul_button)
            textview.setText("${Integer.parseInt(first_input.text.toString())*Integer.parseInt(second_input.getText().toString())}")
        else if(p0 == div_button)
            textview.setText("${Integer.parseInt(first_input.getText().toString())/Integer.parseInt(second_input.getText().toString())}")
        else if(p0 == add_button)
            textview.setText("${Integer.parseInt(first_input.getText().toString())+Integer.parseInt(second_input.getText().toString())}")
        else if(p0 == minus_button)
            textview.setText("${Integer.parseInt(first_input.getText().toString())-Integer.parseInt(second_input.getText().toString())}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_button.setOnClickListener(this)
        minus_button.setOnClickListener(this)
        div_button.setOnClickListener(this)
        mul_button.setOnClickListener(this)
    }
}
