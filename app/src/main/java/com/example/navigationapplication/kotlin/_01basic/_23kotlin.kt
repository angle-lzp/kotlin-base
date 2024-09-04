package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/29/2023 8:23 AM
 * description:
 */

//todo set集合的使用
fun main() {
//    funMutableSet();

    funNotVariableSet();
}

/**
 * 可变
 */
private fun funMutableSet(): Unit {
    val set: MutableSet<String> = mutableSetOf("angelo", "tom", "make", "make")

    set += "andrew"
    set -= "tom"

    set.add("lucy")
    set.remove("make")

    println(set)
}

/**
 * 不可变set
 */
private fun funNotVariableSet(): Unit {
    //todo 不可变
    val set: Set<String> = setOf("angelo", "tom", "make", "make")
    println(set.size)
    println(set.elementAt(0))
    println(set.elementAt(1))
    println(set.elementAt(2))

    //想用下面的格式
    println(set.elementAtOrElse(8) { "你越界了！" })

    println(set.elementAtOrNull(100))
}