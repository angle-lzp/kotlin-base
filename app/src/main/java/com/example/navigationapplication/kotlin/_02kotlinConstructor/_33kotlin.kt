package com.example.navigationapplication.kotlin._02kotlinConstructor

/**
 * author: Angelo.Luo
 * date : 12/29/2023 11:03 AM
 * description:
 */

// todo 惰性加载：需要的时候自己自动加载；
fun main() {

    //不使用惰性加载（在创建对象的时候就会对data进行加载）
    var p = _33kotlin()
    Thread.sleep(3000)
    println(p.show())

    println("-------------------------------------")
    //使用惰性加载
    var pp = _033kotlin()
    Thread.sleep(3000)
    println(pp.show())
//    println(pp.data)
}

class _33kotlin() {

    var data = show();

    fun show(): String? {
        println("Is it convenient for you to come to the meeting now??")
        println("Is it convenient for you to come to the meeting now??")
        println("Is it convenient for you to come to the meeting now??")
        println("Is it convenient for you to come to the meeting now??")
        println("Is it convenient for you to come to the meeting now??")
        println("Is it convenient for you to come to the meeting now??")
        println("Is it convenient for you to come to the meeting now??")
        return "饿汉式加载！"
    }

}

class _033kotlin() {

    //惰性加载需要用val来接收
    //只要data或者show()没有被调用，就不会给data赋值
    val data by lazy { show() }

    fun show(): String? {
        println("you are right!")
        println("you are right!")
        println("you are right!")
        println("you are right!")
        println("you are right!")
        println("you are right!")
        return "惰性加载！"
    }
}