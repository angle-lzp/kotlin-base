package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/28/2023 2:20 PM
 * description:
 */

//todo == and === ,foreach
fun main() {

    //todo ==:比值；===：表引用
    val str1: String = "angelo"
    val str2: String = "angelo"
    val str3: String = "derry"
    println(str1 == str2)
    println(str1 === str2)//jvm中有个字符串常量池
    println(str2 === str3)

    //todo foreach
    val str4: String = "angelo"
    str4.forEach {
        println("我是：$it")
    }
}
