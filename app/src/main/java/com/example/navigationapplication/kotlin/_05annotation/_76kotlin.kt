package com.example.navigationapplication.kotlin._05annotation

/**
 * author: Angelo.Luo
 * date : 01/04/2024 4:14 PM
 * description:
 */

//todo 注解：@JvmField
class Person {
    //使用该注解在Java代码中可以直接调用过变量名，例如：new Person().names
    @JvmField
    val names = listOf("angelo", "javan", "steven")

    //反之：new Person().getDatas()
    val datas = listOf(1, 2, 3)
}