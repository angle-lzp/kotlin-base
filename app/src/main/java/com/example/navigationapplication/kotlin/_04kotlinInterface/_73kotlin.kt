package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo 互操作性和可空性
fun main() {

    /**
     * 引入Java的语言在返回的类型上，kt会加上？，如下：String！
     */
    //1.错误的写法（因为info02返回的是一个null，此时空指针异常）
    println(_73kotlin().info01.length)
    println(_73kotlin().info02.length)
//    val t: String! = _73kotlin().info02
//    var info011: String! = _73kotlin().info01

    //2.正确写法(不写？也不会给出提示，不太推荐这样写，可能会忘记写？)
    println(_73kotlin().info01?.length)
    println(_73kotlin().info02?.length)

    //3.正确写法(直接通过String?来接收，在使用的时候就必须加上？，不然的话编译不通过)
    var info01: String? = _73kotlin().info01
    var info02: String? = _73kotlin().info02

    println(info01?.length)
    println(info02?.length)


}