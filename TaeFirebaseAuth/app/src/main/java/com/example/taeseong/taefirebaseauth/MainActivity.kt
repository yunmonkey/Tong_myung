package com.example.taeseong.taefirebaseauth

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var authStateListener : FirebaseAuth.AuthStateListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //로그인 세션을 체크하는 부분   로그인이 되어있나 안되어있나 체크하는것!
        authStateListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
//            로그아웃 시키면 user값이 null이 되면서 if문장부분이 성립되지 않아서 기존 로그인 부분으로 되돌아 간다.
            var user = firebaseAuth.currentUser
            if(user != null){
                startActivity(Intent(this, HomeActivity::class.java))
                /*
                로그인이 되었을때 넣으면 안되나? 라고 생각하는데 그렇게 되면 페이스북 로그인이 되어있는데 구글로그인을 요청하는일이
                발생될수 있기 때문에 현재 유저가 있으면 새로운 액티비티가 생성되게 되어야 한다!
                그렇기 때문에 startActivity는 authStateListener에 있는것이 맞다
                 */
            }
        }
        button_signUp.setOnClickListener {
            createEmailId()
        }

        button_login.setOnClickListener{ view ->
            loginId()
        }

    }
    fun createEmailId(){
//        createUserWithEmailAndPassword는 이메일과 패스워드값 받아와서 만들어 주는것이고 결과값을 받아오기 위해서는
//        .addOnCompleteListener로 확인한다! task -> 하고 if 문 안에서 task.isSuccessful넣어줌
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(editText_email.text.toString(), editText_password.text.toString())
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "회원가입이 완료 되었습니다.", Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
    }

    fun loginId(){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(editText_email.text.toString(), editText_password.text.toString())
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
    }

    override fun onResume() {
        super.onResume()
        FirebaseAuth.getInstance().addAuthStateListener(authStateListener!!) //앱이 가동될때 파이어베이스어스에다가 줌
    }

    override fun onStop() {
        super.onStop()
        FirebaseAuth.getInstance().removeAuthStateListener(authStateListener!!)
    }
}
