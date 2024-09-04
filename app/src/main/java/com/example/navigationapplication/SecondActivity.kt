package com.example.navigationapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * author: Angelo.Luo
 * date : 01/12/2024 2:50 PM
 * description:Activity直接按的跳转， 并且携带数据
 * 与MainActivity进行测试使用，联合起来一起看
 */
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * 3.从上一个activity获取数据
         * A Activity --> B Activity
         */
        /*        val userName = intent.getStringExtra("userName")
                val password = intent.getIntExtra("password", 0)//整形的需要给一个默认值

                var textView = TextView(this)
                textView.text =
                    String.format("SecondActivity：userName is %s,password is %s", userName, password)
                textView.gravity = Gravity.CENTER
                textView.textSize = 15f
                setContentView(textView)*/

        /**
         * 4.从上一个Activity获取数据,并携带数据返回到上一个Activity
         * A Activity --> B Activity --> A Activity
         */
        val userName = intent.getStringExtra("userName")
        val password = intent.getIntExtra("password", 0)//整形的需要给一个默认值

        var textView = TextView(this)
        textView.text =
            String.format("SecondActivity：userName is %s,password is %s", userName, password)
        textView.gravity = Gravity.CENTER
        textView.textSize = 15f
        setContentView(textView)
        textView.setOnClickListener {
            //这里设置一个Intent来接收数据就可以的
            val resultIntent = Intent()
            resultIntent.putExtra("other", "you are smart")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        Log.e("SecondActivity：", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e("SecondActivity：", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("SecondActivity：", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("SecondActivity：", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("SecondActivity：", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("SecondActivity：", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("SecondActivity：", "onDestroy")
    }
}