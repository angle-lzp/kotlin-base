package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/29/2023 8:23 AM
 * description:
 */

//todo kotlin内置函数takeIf
fun main() {

    val userName: String = "root2"
    val password: String = "luo123"
    println(getPermission(userName, password))

    println(null ?: "你是空呀")

    //真正的用法
    println(getPermission(userName, password) ?: "你没有权限登入，重新输入账号和密码！")

    println(userName!!.length)

}

fun getPermission(userName: String, password: String): String? {
    //todo 用法：当verifyPermission(userName, password)返回的是true，那么takeIf返回userName;否则返回null
    return userName.takeIf {
        verifyPermission(userName, password)
    }
}

private fun verifyPermission(userName: String, password: String): Boolean {
    return userName == "root" && password == "luo123"
}