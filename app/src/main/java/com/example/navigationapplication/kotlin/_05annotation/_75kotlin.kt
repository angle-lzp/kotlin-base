@file:JvmName("Stu")//就是在编译时期，修改我们的类名，让Java端调用更加简单；必须写在包名的前面

package com.example.navigationapplication.kotlin._05annotation

/**
 * author: Angelo.Luo
 * date : 01/04/2024 4:14 PM
 * description:
 */

//todo 注解：@JvmName
fun main() {
    println(System.getProperties().get("java.version"))
}

fun printInfo(str: String): Unit = println(str)