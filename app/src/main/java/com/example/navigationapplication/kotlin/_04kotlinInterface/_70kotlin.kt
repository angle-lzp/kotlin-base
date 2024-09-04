package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo 集合类的过滤函数-filter
fun main() {

    val list = listOf("angelo", "make")
    val filterList = list.filter {
        it.contains("o")
    }
    println(filterList)
}