package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo 可空类型扩展函数

fun String?.outputStringValue(defaultValue: String) = println(this ?: defaultValue)

fun main() {

    //String?:可接受null值和有值数据
    //String: 只能接收有值数据
    val str: String? = null
    str.outputStringValue("啥也不是！")
}
