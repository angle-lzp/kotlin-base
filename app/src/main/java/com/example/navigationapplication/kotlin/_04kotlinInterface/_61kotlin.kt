package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo 扩展属性

//普通变量赋值
val infoData: String = "data"

//类属性扩展（需要用到get，不能直接赋值）(扩展属性)
val String.infoData
    get() = "infoData"

//扩展函数
fun String.printInfoData() = println("infoData is $this")

fun main() {
    String().infoData.printInfoData()
}