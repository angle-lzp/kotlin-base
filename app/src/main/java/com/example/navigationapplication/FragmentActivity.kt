package com.example.navigationapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationapplication.ui.third.ThirdFragment

/**
 * author: Angelo.Luo
 * date : 01/12/2024 5:09 PM
 * description:Fragment 的基本使用
 */
class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置内容布局
        setContentView(R.layout.activity_third)
        var fragment = ThirdFragment()
        //传入参数
        var bundle = Bundle()
        bundle.putInt("age", 23)
        bundle.putString("userName", "angelo")
        fragment.arguments = bundle
        var ft = supportFragmentManager.beginTransaction()
        /**
        //没有添加的时候添加进入(查看fragment是否被添加上容器中)
        if(!fragment.isAdded){
        ft.add(R.id.container,fragment)
        }
        //展示
        ft.show(fragment)
        //隐藏
        ft.hide(fragment)
        //移除
        ft.remove(fragment)
        //替换
        ft.replace(R.id.container,fragment)//替换fragment，之前添加的会被移除，当前的会被添加；
        //必须要进行提交哦
        ft.commitNowAllowingStateLoss()
         */
        //将fragment放到，ID为container的容器中
        ft.add(R.id.container, fragment)
        //将添加的操作的进行提交（必须）
        ft.commitNowAllowingStateLoss()
    }
}