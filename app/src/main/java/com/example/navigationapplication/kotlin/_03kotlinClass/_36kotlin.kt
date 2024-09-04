package com.example.navigationapplication.kotlin._03kotlinClass

import java.io.File

/**
 * author: Angelo.Luo
 * date : 12/29/2023 11:03 AM
 * description:
 */

// todo is、as关键字的使用
fun main() {

    val person: Person2 = Student2("making");
    person.fly()

    println(person is Person2)
    println(person is Student2)
    println(person is File)

    println(person.javaClass)

    val obj = person as Student2
    println(obj.javaClass)

    println(obj.eat())
}

open class Person2(private val name: String) {
    open fun fly(): Unit {
        println("父类中自由的飞翔!")
    }

    private fun eat(): Unit {
        println("不够你吃的!")
    }
}

class Student2(private val name: String) : Person2("angelo") {

    override fun fly() {
        println("我是子类的方法我要把你重写了")
    }

    fun eat(): Unit {
        println("我是子类中的eat")
    }
}