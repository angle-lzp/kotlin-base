package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo 泛型扩展函数

//下面这样的就是泛型扩展函数
fun <T> T.printLength() =
    println("${if (this is String) "字符串的长度为${this.length}" else "不是字符串类型！"}")

fun <R> R.showCurrentTime() = println("当前的时间是：${System.currentTimeMillis()},当前对象是：$this")

fun main() {
    "angelo".printLength()
    Any().printLength()

    "angelo".showCurrentTime()
    'C'.showCurrentTime()
    listOf<String>().showCurrentTime()

    "angelo".let {

    }
}