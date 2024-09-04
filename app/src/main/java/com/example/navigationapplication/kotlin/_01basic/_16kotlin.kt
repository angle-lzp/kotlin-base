package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/28/2023 2:20 PM
 * description:
 */

//todo kotlin的内转换函数run
fun main() {

    val str1: String = "angelo"

    //todo 使用匿名函数的方式如下
    //run函数里面的形参是this == 本身，返回的数据看最后一行返回什么那就接受什么
    str1.run {
        length == 6
    }.run {
        if (this) "符合规范的" else "这不对呀，不符合规范！"
    }.run {
        this
    }.run {
        println(this)
    }

    //todo 使用具名函数的方式如下
    str1.run(::checkLength).run(::showText).run(::toMapText).run(::println)

    //todo 使用let函数也是一样的，可以实现像run这样的效果
    str1.let(::checkLength).let(::showText).let(::toMapText).let(::println)


}

fun checkLength(msg: String) = msg.length == 5
fun showText(msg: Boolean) = if (msg) "符合规范的" else "这不对呀，不符合规范！"
fun toMapText(msg: String) = "[$msg]"
