package com.example.navigationapplication.ui.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast

/**
 * author: Angelo.Luo
 * date : 01/16/2024 9:57 AM
 * description:
 */
class TestBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action?.equals(ConnectivityManager.CONNECTIVITY_ACTION) == true) {
            val connectivityManager: ConnectivityManager =
                context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = connectivityManager.activeNetworkInfo
            if (info != null && info.isAvailable) {
                val typeName = info.typeName
                Log.e("TestBroadcastReceiver", "当前网络名称$typeName")
                Toast.makeText(context, "当前网络名称$typeName", Toast.LENGTH_SHORT).show()
            } else {
                Log.e("TestBroadcastReceiver", "当前无网络链接")
                Toast.makeText(context, "当前无网络链接", Toast.LENGTH_SHORT).show()
            }
        } else if ("com.example.navigationapplication.ui.receiver" == intent?.action) {
            Log.e("TestBroadcastReceiver", "我自定义的")
            Toast.makeText(context, "我自定义的！", Toast.LENGTH_SHORT).show()
        } else {
            Log.e("TestBroadcastReceiver", "啥也不是")
            Toast.makeText(context, "啥也不是！", Toast.LENGTH_SHORT).show()
        }
    }
}