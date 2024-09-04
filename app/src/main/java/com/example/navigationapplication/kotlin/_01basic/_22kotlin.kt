package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/29/2023 8:23 AM
 * description:
 */

//todo kotlin的结构语法的过滤学习
fun main() {

    val list: List<String> = listOf("angelo", "making", "tom");
    //像下面的这个格式就是一个结构化
    val (v1, v2, v3) = list;
    println("$v1 $v2 $v3")

    //下面的下划线_，表示结构化过滤，第一个参数数据就是不会用，相当于有个位置占用了这个数据，但是不显示不赋值
    val (_, value2, value3) = list;
    println("$value2, $value3")


}