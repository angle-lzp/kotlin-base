package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/28/2023 10:54 AM
 * description:
 */

//todo 对于空的情况使用let的安全性操作
fun main() {

    var str: String? = null;
    str = "angelo";
//    str = null;

    var strTemp = str?.capitalize()
    println(strTemp)

    //当str不为空的时候才会执行let里边的代码
    var result = str?.let {
        if (it.isBlank()) {
            "angelo"
        } else {
            "[$it]"
        }
    }

    println(result)
}