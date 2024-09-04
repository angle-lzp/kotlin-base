package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/28/2023 10:54 AM
 * description:
 */

//todo 函数类型的引用（将一个普通函数变成一个函数类型的对象（函数引用））
fun main() {
    login22("angelo", "123456", ::methodReference)
}

fun methodReference(msg: String, code: Int): Unit {
    println("$msg and $code")
}

inline fun login22(userName: String, password: String, responseResult: (String, Int) -> Unit) {
    if (userName.length == 6) {
        responseResult(userName + password, 200)
    } else {
        responseResult(userName + password, 400)
    }
}