package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo 抽象类
abstract class BaseActivity {
    fun onCreate() {
        setContentView(getLayoutId())
        initView()
        initData()
    }

    private fun setContentView(layoutId: Int) = println("加载布局Id = $layoutId")

    abstract fun getLayoutId(): Int
    abstract fun initView()
    abstract fun initData()
}


class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return (1..100).shuffled().last()
    }

    override fun initView() {
        println("初始化试图")
    }

    override fun initData() {
        println("初始化数据")
    }
}

fun main() {
    val activity : BaseActivity = MainActivity();
    activity.onCreate()
}