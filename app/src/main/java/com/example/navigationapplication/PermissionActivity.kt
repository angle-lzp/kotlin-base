package com.example.navigationapplication

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

/**
 * author: Angelo.Luo
 * date : 01/16/2024 11:21 AM
 * description:内容提供者：ContentProvider
 */
class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //先检查是否已经授权访问通讯录
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Log.e("PermissionActivity", "检查到没有权限!")
            //没有授权的话，那就申请权限
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_CONTACTS),
                100
            )
/*            if(ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.READ_CONTACTS)){
                //在这里弹框引导用户，去设置打开读写联系人的权限；
            }*/
        } else {
            Log.e("PermissionActivity", "检查到获取了权限!")
            //获取权限进行对应操作
            getContact()
        }
    }

    /**
     * 获取权限后处理授权的结果
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,//返回上面申请权限加入的请求code
        permissions: Array<out String>,//获取的权限有哪些
        grantResults: IntArray//获取权限后返回的结果：成功还是失败
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100 && permissions[0] == android.Manifest.permission.READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getContact()
                Log.e("PermissionActivity", "获取到了权限!")
                Toast.makeText(this, "获取到了权限！", Toast.LENGTH_SHORT).show()
            } else {
                Log.e("PermissionActivity", "没有获取到权限!")
                Toast.makeText(this, "没有获取到权限！", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun getContact() {
        Log.e("PermissionActivity", "获取用户通讯录信息!")
    }
}