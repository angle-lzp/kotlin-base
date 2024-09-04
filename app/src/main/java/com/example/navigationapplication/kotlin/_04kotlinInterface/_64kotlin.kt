package com.example.navigationapplication.kotlin._04kotlinInterface

//导入扩展文件中的扩展方法
import com.example.navigationapplication.kotlin._04kotlinInterface.angelo.randomValue
import com.example.navigationapplication.kotlin._04kotlinInterface.angelo.randomValuePrint


/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo 定义扩展文件
fun main() {
    val set: Set<String> = setOf("Angelo", "Andrew", "lucy")

    val list: List<String> = listOf("making", "lili", "join")

    println(set.randomValue())
    println(list.randomValue())

    println()

    set.randomValuePrint()
    list.randomValuePrint()
}