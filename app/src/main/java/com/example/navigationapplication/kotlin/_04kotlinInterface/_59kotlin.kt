package com.example.navigationapplication.kotlin._04kotlinInterface

import kotlinx.coroutines.*

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo 定义扩展函数

//1.如下就是自定义的函数：看案例就知道了
fun String.showStr(number: Int) {
    println(this + "@".repeat(number))
}

//2.用在超类上那是极其恐怖的
fun Any.print(data: String) {
    println("data = [${data}]")
}

//3.扩展函数不允许重复定义
//fun Any.print(data: String) {
//    println("data = [${data}]")
//}

//4.kt内置的扩展函数，被重复定义，会优先使用我们自己重写的函数

fun main() {
    "angelo".showStr(10)

    "angelo".print("zhang shan")

    "ksjdfas".print("ccccc")
    runBlocking {
        val job = launch(Dispatchers.Default) {
            repeat(10) {
                delay(1000L)
                println("Hello, World!")
            }
        }
        job.join()
    }
}