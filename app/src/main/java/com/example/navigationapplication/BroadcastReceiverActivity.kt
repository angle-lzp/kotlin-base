package com.example.navigationapplication

import android.content.ComponentName
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationapplication.ui.receiver.TestBroadcastReceiver

/**
 * author: Angelo.Luo
 * date : 01/16/2024 9:55 AM
 * description:广播接收者
 */
class BroadcastReceiverActivity : AppCompatActivity() {

    private lateinit var testBroadcastReceiver: TestBroadcastReceiver;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * 1.动态注册(建议使用这种)
         */
        /*testBroadcastReceiver = TestBroadcastReceiver()
        //创建广播过滤器，指定接收android.net.conn.CONNECTIVITY_CHANGE的广播事件
        var intentFilter = IntentFilter()
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(testBroadcastReceiver, intentFilter)*/

        /**
         * 2.静态注册：看AndroidManifest.xml中
         */

        /**
         * 3.自定义注册(需要再AndroidManifest.xml中注册)
         */
        val intent = Intent()
        intent.action = "com.example.navigationapplication.ui.receiver"
        intent.component = ComponentName(
            packageName,
            "com.example.navigationapplication.ui.receiver.TestBroadcastReceiver"
        )
        //发送广播
        sendBroadcast(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        //只有动态注册才需要下面的发注册
//        unregisterReceiver(testBroadcastReceiver)
    }
}