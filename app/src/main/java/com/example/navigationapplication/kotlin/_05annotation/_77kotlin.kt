package com.example.navigationapplication.kotlin._05annotation

/**
 * author: Angelo.Luo
 * date : 01/04/2024 4:14 PM
 * description:
 */

//Java中不能使用默认参数的形式，使用下面注解会重载该方法；在Java中便可以使用了
@JvmOverloads
fun show(name: String, age: Int = 20) {
    println("name = [${name}], age = [${age}]")
}

//todo 注解：@
fun main() {
    //kotlin可以使用默认参数的形式
    show("angelo")
}

