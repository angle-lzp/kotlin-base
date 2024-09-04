package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/28/2023 10:54 AM
 * description:
 */

//todo 匿名函数和具名函数（有具体名称的函数）
fun main() {

    //todo 匿名函数
    returnFunction02("angelo", "123456") {
        println(it)
    }

    //todo 具名函数
    returnFunction02("angelo", "987653", ::concreteMethod)
}

fun concreteMethod(str: String): Unit {
    println("我就是顺便打印的：$str")
}

fun returnFunction02(userName: String, password: String, method: (String) -> Unit) {
    println("userName is $userName,password is $password")
    var str: String = "userName is $userName,password is $password"
    method(str)
}