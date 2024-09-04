package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/28/2023 2:20 PM
 * description:
 */

//todo kotlin的内置转换函数let
fun main() {

    //let:取值的处理
    var num = listOf<Int>(5, 2, 3, 56, 3, 3).let {
        it.first() + it.last()
    }

    println(num)

    //null值的处理
    println(getResult(null))

    println(getResult2(null))
}

// 复杂写法
fun getResult(msg: String?): String {
    return msg?.let {
        "我是有值的：$msg"
    } ?: "我就是没有值，在噶东西！！！"
}


// 简单写法
fun getResult2(msg: String?) = msg?.let {
    "我是有值的：$msg"
} ?: "我就是没有值，在噶东西！！！"