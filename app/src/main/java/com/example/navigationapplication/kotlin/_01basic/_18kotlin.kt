package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/28/2023 2:20 PM
 * description:
 */

//todo kotlin的内转换函数also
fun main() {

    val str1 : String = "angelo"
    //默认的形参变量名称是it（apply是this），返回的类型全都是str1，本身
    //_14kotlin.kt
    str1.also{
        println(it.length)
    }.also{
        println(it[2])
    }.also {
        println("原始的操作：$it")
    }.also {
        println("变形后的数据：${it.toUpperCase()}")
    }

}
