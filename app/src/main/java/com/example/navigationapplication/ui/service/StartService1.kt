package com.example.navigationapplication.ui.service

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 * author: Angelo.Luo
 * date : 01/15/2024 3:51 PM
 * description:
 */
class StartService1 : Service() {

    //必须要实现的方法
    override fun onBind(intent: Intent?): IBinder? {
        Log.e("StartService1", "onBind")
        return null
    }

    override fun startService(service: Intent?): ComponentName? {
        Log.e("StartService1", "StartService1")
        return super.startService(service)
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("StartService1", "onCreate")
    }

    /**
     *
     * 使用startService普通启动的方式：
     *
     * 对于使用startService的方式而言：onStartCommand就是我们用于做后台任务的地方
     * 多次调用startService，会直接回调onStartCommand，而不会再调用onCreate
     *
     * 这种启动的服务，它的生命周期和应用程序的生命周期一样长，只要应用程序不杀死，改服务就还在，除非调用stopService
     *
     * startService一把来说用于创建一个长时间持续运行的后台任务才会用，比如socket，文件上传下载服务
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("StartService1", "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("StartService1", "onDestroy")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e("StartService1", "onUnbind")
        return super.onUnbind(intent)
    }
}