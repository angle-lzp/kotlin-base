package com.example.navigationapplication

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationapplication.databinding.ActivityStartServiceBinding
import com.example.navigationapplication.ui.service.StartService1
import com.example.navigationapplication.ui.service.StartService2

/**
 * author: Angelo.Luo
 * date : 01/15/2024 3:42 PM
 * description:service
 */
class StartServiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartServiceBinding;

    private var connection: ServiceConnection? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /**
         * 二：bindService：绑定启动方式
         */
        var binder: StartService2.MyBinder? = null

        //保持所启动的Service的IBinder对象,同时定义一个ServiceConnection对象
        connection = object : ServiceConnection {
            //Activity与Service连接成功时回调该方法
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                Log.e("BindService2", "Service Connected")
                /**
                 * 接收连接成功后，发挥的IBinder对象，进行对应的操作
                 */
                binder = service as StartService2.MyBinder
            }

            //Activity与Service断开连接时回调该方法
            override fun onServiceDisconnected(name: ComponentName?) {
                Log.e("BindService2", "Service DisConnected")
            }
        }
        /**
         * 这种绑定启动：是运行一些和Activity周期一样的后台会程序，比如说跨进程通信
         */
        //bind服务
        val intent = Intent(this, StartService2::class.java)
        //绑定启动
        //onCreate、onBind：有多次绑定也只回调一次
        bindService(intent, connection!!, Context.BIND_AUTO_CREATE)
        bindService(intent, connection!!, Context.BIND_AUTO_CREATE)
        //获取数据
        binding.startButton.setOnClickListener {
            Log.e("BindService2", "this data is ${binder?.getCount()}")
        }

        //解绑操作
        binding.endButton.setOnClickListener {
            unbindService(connection!!)
        }


        /* */
        /**
         * 一：startService：普通启动的方式
         *//*
        binding.startButton.setOnClickListener {
            val intent = Intent(this, StartService1::class.java)
            startService(intent)
        }

        binding.endButton.setOnClickListener {
            val intent = Intent(this, StartService1::class.java)
            stopService(intent)
        }*/

    }

    override fun onDestroy() {
        super.onDestroy()
        //上面调用了几次unbindService，在destroy这里也需要调用几次
        unbindService(connection!!)
    }
}