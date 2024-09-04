package com.example.navigationapplication.kotlin._05annotation

/**
 * author: Angelo.Luo
 * date : 01/04/2024 4:14 PM
 * description:
 */

//todo 注解：@JvmField
class Person {
    //使用该注解在Java代码中可以直接中通过变量名调用.names
    @JvmField
    val names = listOf("angelo", "javan", "steven")

    //反之：.getDatas()
    val datas = listOf(1, 2, 3)
}