package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/28/2023 2:20 PM
 * description:
 */

//todo kotlin的内转换函数with
fun main() {

    val str1: String = "angelo"

    //todo 返回的类型和let,run是一样的，返回什么那就接收什么（就是写法有点不太一样就是）
    //具名函数的写法
    var r1 = with(str1, ::getLength)
    var r2 = with(r1, ::getLengthCheck)
    var r3 = with(r2, ::getShowText)
    var r4 = with(r3, ::printlnText)

    //匿名函数的写法
    with(with(with(with(str1) {
        this.length
    }) {
        this > 5
    }) {
        if (this) "有那么长！" else "差一点意思！"
    }) {
        println(this)
    }

}

fun getLength(msg: String) = msg.length
fun getLengthCheck(msg: Int) = msg > 5
fun getShowText(msg: Boolean) = if (msg) "有那么长！" else "差一点意思！"
fun printlnText(msg: String) = println(msg)
