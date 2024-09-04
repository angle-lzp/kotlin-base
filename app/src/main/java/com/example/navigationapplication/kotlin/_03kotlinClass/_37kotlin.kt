package com.example.navigationapplication.kotlin._03kotlinClass

/**
 * author: Angelo.Luo
 * date : 12/29/2023 11:03 AM
 * description:
 */

// todo 类型的智能转换
fun main() {

    val person: Person3 = Student3("making");
    (person as Student3).eat()

    //todo 通过上面的as转换，会记录它转换后的类型；
    person.eat()
    person.eat()

}

open class Person3(private val name: String) {
    open fun fly(): Unit {
        println("父类中自由的飞翔!")
    }

    private fun eat(): Unit {
        println("不够你吃的!")
    }
}

class Student3(private val name: String) : Person3("angelo") {

    override fun fly() {
        println("我是子类的方法我要把你重写了")
    }

    fun eat(): Unit {
        println("我是子类中的eat")
    }
}