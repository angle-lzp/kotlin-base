package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/29/2023 8:23 AM
 * description:
 */

//todo kotlin内置函数takeUnless
fun main() {

    var manager = Manager();

    //todo takeUnless的作用和takeIf是一样的只是里面的true和false刚好相反；
    //todo true:返回null；false：返回manager.getUserName本身的数据
    println(manager.getUserName().takeUnless { it.isNullOrBlank() } ?: "你怎么是空的，搞什么！")

}

class Manager {
    private var userName: String? = null;

    fun getUserName(): String? {
        return this.userName
    }

    fun setUserName(userName: String): Unit {
        this.userName = userName;
    }
}