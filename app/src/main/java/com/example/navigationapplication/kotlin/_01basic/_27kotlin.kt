package com.example.navigationapplication.kotlin._01basic

import kotlin.random.Random

/**
 * author: Angelo.Luo
 * date : 12/29/2023 8:23 AM
 * description:
 */

//todo class 和 field
//todo

class Person {
    //todo var:可变；存在set和get方法
    var userName = "lucy";

    //todo val:不可变、只读；只有get方法,还有一个变量的声明（这样的也称为 计算属性，因为只能读不能写；）
    val password = 123456;

    //todo val:不可变、只读；只有get方法，没有变量的声明；因为这里重写了get()方法（可以通过字节码反编译查看Java代码）
    // （这样的也称为 计算属性，因为只能读不能写；）
    // 其实就是这个变量只读，有个get()方法就可以了，就没有必要再声明这个Field了；所以反编译中看不到这个字段的声明
    val email: String get() = ((1..100).shuffled().toString())

    //(1..100).shuffled().toString():生成一个包含1到100的整数序列，然后将其随机打乱顺序，最后将这个序列转换为字符串


    private var str: String? = null;

    /**
     * 防范竟态条件：当你调用成员变量，这个成员变量可能为null，也可能为空值，就必须采用 防范竟态条件，这个kt的编码规范；
     */
    fun showStr(): String? {
        //这种let写法就是符合 防范竟态条件 ，专业的开发人员都i是这样干的；
        return str?.let {
            if (it.isBlank()) {
                "你是空值的哦！"
            } else {
                "你的值是：$it"
            }
        } ?: "你是null哦！"
    }
}

fun main() {

    println(Person().showStr());

    println(Person().email)

    val intList = (1..30).shuffled()
    println(intList)
    println(intList.size)
    println(intList::class.java)
}