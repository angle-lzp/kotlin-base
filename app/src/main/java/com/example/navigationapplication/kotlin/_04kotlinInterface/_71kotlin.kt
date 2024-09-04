package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo 集合类的合并函数- zip
fun main() {

    /**
     * RxJava zip 合并操作符，kt自带有zip合并操作
     * 原理：将第一个集合和第二个集合按顺序合并到一个pair中，然后再把一个个的pair放到list中；合并之后是生成了一个新的对象pair，然后放在list中
     * 里面存放的元素是：pair
     *
     * 如果两个集合数量对不用：例如一个3个元素，一个2个元素；那么会舍弃第三个元素，值合并二哥元素；
     */

    val nameList = listOf("angelo", "lucy", "make")
    val ageList = listOf(23, 34)

    //一对一的合并：例如：angelo=23
    //如果nameList长度为3，ageList长度为2；那么zip之后的长度为2
    val zip: List<Pair<String, Int>> = nameList zip ageList

    println(zip.toMap()) //{angelo=23, lucy=34, make=32}
    println(zip.toList()) //[(angelo, 23), (lucy, 34), (make, 32)]
    println(zip.toSet()) //[(angelo, 23), (lucy, 34), (make, 32)]

    //遍历
    zip.forEach {
        println("name is ${it.first},age is ${it.second}")
    }

    zip.toMap().forEach {
        println("toMap name is ${it.key},age is ${it.value}")
    }

    //map遍历的普通方式
    zip.toMap().forEach { k: String, v: Int ->
        println("toMap_k-v name is $k,age is $v")
    }

    //map遍历的解构方式
    zip.toMap().forEach { (k, v) ->
        println("toMap_(k-v) name is $k,age is $v")

    }


}