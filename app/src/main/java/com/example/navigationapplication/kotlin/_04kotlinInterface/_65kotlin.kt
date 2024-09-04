package com.example.navigationapplication.kotlin._04kotlinInterface

//导入扩展文件中的扩展方法 进行重命名
import com.example.navigationapplication.kotlin._04kotlinInterface.angelo.randomValue as rv
import com.example.navigationapplication.kotlin._04kotlinInterface.angelo.randomValuePrint as rvp


/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo 定义扩展文件中的重命名
fun main() {
    val set: Set<String> = setOf("Angelo", "Andrew", "lucy")

    val list: List<String> = listOf("making", "lili", "join")

    println(set.rv())
    println(list.rv())

    println()

    set.rvp()
    list.rvp()
}