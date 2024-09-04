package com.example.navigationapplication.kotlin._01basic

import kotlin.math.roundToInt
import kotlin.math.roundToLong

/**
 * author: Angelo.Luo
 * date : 12/28/2023 2:20 PM
 * description:
 */

//todo 字符串，数值转换,Int,Float,Double
fun main() {

    //toInt()只能转是符合Int类型的才可以，否则抛出异常；
    var num1: Int = "98".toInt();
    println(num1)

    //抛出异常：因为"98.45"字符串不符合Int类型
//    var toInt = "98.45".toInt()

    var num2: Float = "98.34".toFloat()
    println(num2)

    var num3: Int = 98.74.toInt() //98 没得四舍五入
    println(num3)

    var num4: Int = 68.4592735.roundToInt()// 68 四舍五入
    println(num4)

    var num5: Long = 68.5592735.roundToLong()//69 四舍五入
    println(num5)
}