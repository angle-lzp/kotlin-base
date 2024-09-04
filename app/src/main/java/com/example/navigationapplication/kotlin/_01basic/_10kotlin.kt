 package com.example.navigationapplication.kotlin._01basic

import java.lang.IllegalArgumentException

/**
 * author: Angelo.Luo
 * date : 12/28/2023 10:54 AM
 * description:
 */

//todo 异常处理和自定义异常
fun main() {

    var str: String? = null;
    str = "angelo";
    str = null;

    // todo 先行执行函数
    check(true) //为false直接抛出异常
//    checkNotNull(str) //为null直接抛出异常

/*
    //为false抛出异常
    require(true)
    require(true) { "嘀哒哒大" }
*/

    try {
        //自定义异常
        checkoutNullPoint2(str);

        str!!.capitalize()
    } catch (e: Exception) {
        println("抛出异常了：${e.toString()}")
    }
}

fun checkoutNullPoint2(str: String?) {
    str ?: throw CustomException()
}

class CustomException : IllegalArgumentException("代码不是很规范的哦")

class CustomException01 : RuntimeException("没错就是我")