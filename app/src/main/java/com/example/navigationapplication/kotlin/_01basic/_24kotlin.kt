package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/29/2023 8:23 AM
 * description:
 */

//todo set<->list
fun main() {

    val list: List<String> = listOf("make", "make")
    println(list)
    //去重方式一:
    var toSet = list.toSet().toList()
    println(toSet)

    //去重方式二：
    val list2: List<String> = listOf("make", "make")
    println(list2.distinct())


}
