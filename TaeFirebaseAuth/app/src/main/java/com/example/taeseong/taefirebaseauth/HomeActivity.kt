package com.example.taeseong.taefirebaseauth

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        button_logout.setOnClickListener {

            FirebaseAuth.getInstance().signOut()
            finish()
        }

        button_passwordChange.setOnClickListener {
            var editTextNewPassword = EditText(this)
            editTextNewPassword.transformationMethod = PasswordTransformationMethod.getInstance() // 입력된 글자가 자동으로 비밀번호 EditText가 됨
            var alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("비밀번호 변경")
            alertDialog.setMessage("변경하고 싶은 패스워드를 입력해주세요!")
            alertDialog.setView(editTextNewPassword)
            alertDialog.setPositiveButton("변경", { dialogInterface, i ->
                changePassword(editTextNewPassword.text.toString())
            })
            alertDialog.setNegativeButton("취소", {dialogInterface, i -> dialogInterface.dismiss() })
            alertDialog.show()
        }
    }
    fun changePassword(password: String){
        FirebaseAuth.getInstance().currentUser?.updatePassword(password)!!.addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(this, "비밀번호 변경이 완료 되었습니다." , Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, task.exception.toString() , Toast.LENGTH_SHORT).show()
            }
        }
    }// 처음에 비밀번호 변경키를 누르면 오류가 난다 그 이유는 세션이 아직 로그인 상태이기 때문에 로그아웃을 해주고나서 다시 새롭게 로그인을 하고
//    비밀번호를 변경해 주어야 한다!
}
