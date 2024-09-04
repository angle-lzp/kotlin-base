package com.example.navigationapplication.ui.service

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

/**
 * author: Angelo.Luo
 * date : 01/15/2024 3:51 PM
 * description:
 */
class StartService2 : Service() {


    private var count = 0;
    private var quit = false;//是否退出：true:退出；false:不退出

    //定义onBinder方法所返回的对象
    private val binder: MyBinder = MyBinder()

    inner class MyBinder : Binder() {

        fun getCount(): Int {
            return count;
        }
    }

    /**
     * 有多次绑定也只回调一次
     * bindService：首次创建回调，service被床架你回调
     */
    override fun onCreate() {
        super.onCreate()
        Log.e("StartService2", "onCreate")
        //创建一个线程动态修改count值
        Thread {
            while (!quit) {
                try {
                    Thread.sleep(1000)
                    count++;
                } catch (e: Exception) {
                    e.printStackTrace()
                    Log.e("StartService2-问题：", e.message.toString())
                }
            }
        }.start()
    }


    /**
     * 必须要实现的方法-有多次绑定也只回调一次
     * bindService：首次创建回调,并且返回这个IBinder对象
     */
    override fun onBind(intent: Intent?): IBinder? {
        Log.e("StartService2", "onBind")
        return binder
    }

    override fun startService(service: Intent?): ComponentName? {
        Log.e("StartService2", "StartService2")
        return super.startService(service)
    }

    /**
     * 使用bindService绑定启动的方式：
     *
     *
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("StartService2", "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    /**
     * service断开连接时回调
     */
    override fun onUnbind(intent: Intent?): Boolean {
        Log.e("StartService2", "onUnbind")
        return super.onUnbind(intent)
    }

    /**
     * Service被关闭前回调
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.e("StartService2", "onDestroy")
    }

    //重新绑定
    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        Log.e("StartService2", "onRebind")
    }
}