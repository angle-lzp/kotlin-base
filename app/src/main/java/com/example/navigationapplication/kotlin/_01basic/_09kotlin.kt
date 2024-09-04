package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/28/2023 10:54 AM
 * description:
 */

//todo 空合并操作符号
fun main() {

    var str: String? = null;
    str = "angelo";
    str = null;

    //表示：当str为null的时候，返回后面的数据；不为空返回str本身的数据
    println(str ?: "你是为null哦！")

    //todo 也可以配合let进行使用
    println(str?.let { "[$it]" } ?: "你就是null的！")
}