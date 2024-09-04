package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo infix关键字（中缀表达式）
//infix == 中缀表达式可以简化代码

private infix fun <T1, T2> T1.gogogo(value: T2) {
    println(this)
    println(value)
}

fun main() {

    //下面的map就是使用了中缀表达式(to)
    val map: Map<String, String> = mapOf("angelo" to "1", "angle" to "2")

    //自定义的中缀表达式
    "angelo" gogogo "nice"


    val str: String = "Angelo." plus "Luo";
    val value: String = "Angelo.".plus("Luo")
    str.let {

    }
    println(str)
}

private infix fun <T1, T2> T1.plus(value: T2): String {
    return StringBuilder(this.toString()).append(value.toString()).toString()
}