package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/28/2023 10:54 AM
 * description:
 */

//todo 可空性（null）
fun main() {

    //直接赋值为null是不允许的;
    // todo 默认就是不可空的类型
    //var str : String = null;

    //如果需要赋值为null，可以通过？来进行强制赋值
    var str1: String? = null
    //str1 = "angelo"
    println(str1)

}