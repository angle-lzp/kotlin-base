package com.example.navigationapplication.kotlin._01basic

import java.io.File

/**
 * author: Angelo.Luo
 * date : 12/28/2023 2:20 PM
 * description:
 */

//todo kotlin的内置高级函数apply
fun main() {

    val str1: String = "angelo"
    println(str1.length)
    println(str1[str1.length - 1])

    //使用apply这样是匿名函数的方式：本来默认的是有一个it形参变量，但是现在是换成了this == str1本身
    //并且apply返回的对象也是当前对象本身this
    var str11: String = str1.apply {
        println(length)
        println(this[length - 1])
        println(this)
    }

    println(str11)

    //因为返回的就是this所有如下：用法如下
    str1.apply {
        println(length)
    }.apply {
        println(this[length - 2])
    }.apply {
        println(this)
    }

    //例子如下：
    val file: File = File("c://Applications//a.txt")

    file.apply {
        setExecutable(true)
    }.apply {
        setReadable(true)
    }.apply {
        println(readLines())
    }


}
