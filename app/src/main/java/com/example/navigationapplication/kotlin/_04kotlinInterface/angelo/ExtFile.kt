package com.example.navigationapplication.kotlin._04kotlinInterface.angelo

/**
 * author: Angelo.Luo
 * date : 01/04/2024 9:23 AM
 * description:扩展文件：写在一整个文件的里边的扩展函数、扩展字段
 */

fun <E> Iterable<E>.randomValue(): E = this.shuffled().first()

fun <E> Iterable<E>.randomValuePrint(): Unit = println(this.shuffled().first())


