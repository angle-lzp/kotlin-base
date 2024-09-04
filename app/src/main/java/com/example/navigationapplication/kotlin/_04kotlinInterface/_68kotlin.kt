package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo 集合类的变换函数-map
fun main() {

    //T T T --> 新的集合(R,R,R)
    //原理：把匿名函数的最后一行的返回值 加入到一个新的集合中，新集合的类型由最后一行返回的类型决定
    val list : List<String> = listOf("angelo","making","javan")
    val listNew = list.map {
        println(it.length)
    }
    println(listNew)//[kotlin.Unit, kotlin.Unit, kotlin.Unit] 返回的是void

}