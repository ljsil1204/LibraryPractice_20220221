package com.neppplus.librarypractice_20220221

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    fun setupEvents() {

        btnCall.setOnClickListener {

//            권한 승인 여부에 따른, 행동방안을 작성해서 => pl 변수에 담아두자.
            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
//                    승인이 OK 일때 할 행동
                    val myUri = Uri.parse("tel:01033337777")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
//                    거절 되었을 때 할 행동.
                    Toast.makeText(this@MainActivity, "권한이 거절되어, 통화가 불가능합니다", Toast.LENGTH_SHORT)
                        .show()
                }

            }

//            실제로 권한을 물어보자.
            TedPermission.create()
                .setPermissionListener(permissionListener)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }


//        버튼 이외의, TextView, ImageView, LinearLayout 등등도 setOnClickListener 로 이벤트 처리가 가능함.
        imgProfile.setOnClickListener {

//            사진을 크게 보는 액티비티로 이동
            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)

        }

    }

    fun setValues() {

        Glide.with(this).load("https://thumb.mt.co.kr/06/2022/02/2022021010191966114_1.jpg/dims/optimize/").into(imgActivity)

    }

}