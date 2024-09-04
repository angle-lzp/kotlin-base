package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/28/2023 10:54 AM
 * description:
 */

//todo 函数返回一个函数（一个函数的返回结果是一个函数）
fun main() {

    val method: (Int) -> String = returnFunction("angelo", "123456")
    println(method(200))

    val method01 : (Int)->String = returnFunction2("angelo","987653")
    println(method01(404))
}

fun returnFunction(userName: String, password: String): (Int) -> String {
    println("userName is $userName,password is $password")
    return {
        "当前返回的账号、密码、code is $userName,$password,$it"
    }
}

fun returnFunction2(userName: String, password: String): (Int) -> String {
    println("userName is $userName,password is $password")
    return ::method01
}

fun method01(code: Int): String {
    return "返回的code是：$code"
}