package com.example.navigationapplication.kotlin._03kotlinClass

/**
 * author: Angelo.Luo
 * date : 12/29/2023 11:03 AM
 * description:
 */

// todo 继承关系、open关键字
fun main() {

    val person: Person = Student("making");
    person.fly()
}

//加上open才可以被继承
open class Person(private val name: String) {
    //这个方法要被重写就得加上open
    open fun fly(): Unit {
        println("父类中自由的飞翔!")
    }

    private fun eat(): Unit {
        println("不够你吃的!")
    }
}

class Student(private val name: String) : Person("angelo") {

    override fun fly() {
        println("我是子类的方法我要把你重写了")
    }

    fun eat(): Unit {
        println("我是子类中的eat")
    }
}