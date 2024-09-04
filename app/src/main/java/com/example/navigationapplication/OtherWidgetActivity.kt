package com.example.navigationapplication

import android.app.AlertDialog
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

/**
 * author: Angelo.Luo
 * date : 01/19/2024 3:45 PM
 * description:
 */
class OtherWidgetActivity : AppCompatActivity() {

    private lateinit var manager: NotificationManager;
    private lateinit var notification: Notification;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.other_widget)
        manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val channel =
            NotificationChannel("angelo", "测试通知", NotificationManager.IMPORTANCE_HIGH)
        manager.createNotificationChannel(channel)

        //创建通知的内容
        notification = NotificationCompat.Builder(this, "angelo")
            .setContentTitle("官方通知")//标题
            .setContentText("世界很大我想去看看是什么样子的。")//内容
            .setSmallIcon(R.drawable.ic_notifications_black_24dp)//图标
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.icon_course))//通知右边的图片
            .build()


    }

    fun sendNotification() {

        manager.notify(1, notification)

    }

    fun cancelNotification() {
        manager.cancel(1)

    }

    fun alertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("警告")
            .setMessage("出现了火灾")
            .setIcon(R.drawable.icon_collect)
            .create()
            .show()
    }

    /**
     * 点击之后会出现对应的控件，失去焦点、取消，该控件会消失。
     */
    fun popupWindows(view: View) {
        val popupView = layoutInflater.inflate(R.layout.other_widget_popupwindows, null)
        var popupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            500,
            true//失去焦点消失
        )
        //展示(表示展示在哪个view的下面)
        popupWindow.showAsDropDown(view)
        //点击事件
        popupView.findViewById<Button>(R.id.btn1).setOnClickListener {
            Log.e("popup", "确认")
        }

        popupView.findViewById<Button>(R.id.btn2).setOnClickListener {
            Log.e("popup", "取消")
            //取消后就消失
            popupWindow.dismiss()
        }
    }
}