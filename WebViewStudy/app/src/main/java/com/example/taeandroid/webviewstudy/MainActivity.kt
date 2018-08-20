package com.example.taeandroid.webviewstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.webViewClient = WebViewClient()

        buttonNaver.setOnClickListener { view ->
            webView.loadUrl("http://www.naver.com")
        }
        buttonDaum.setOnClickListener {
            webView.loadUrl("https://www.daum.net")
        }
        buttonGoogle.setOnClickListener {
            webView.loadUrl("http://www.google.com/")
        }
    }
}
