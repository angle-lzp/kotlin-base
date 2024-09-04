package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/28/2023 10:54 AM
 * description:
 */

//todo 非空断言操作符：使用：!!-->如果为空的话直接抛出空指针异常
fun main() {

    var str: String? = null;
    str = "angelo";
    str = null;

    //下面这个形式就和Java的是一样了：如果为空就抛出空指针异常
    //!!相当于强制执行，不管是不是null
    var result = str!!.capitalize()

    println(result)

    //todo 也可以使用if进行判空的操作
}