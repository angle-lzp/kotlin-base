package com.example.navigationapplication.kotlin._03kotlinClass

/**
 * author: Angelo.Luo
 * date : 12/29/2023 11:03 AM
 * description:
 */

// todo 对象表达式
fun main() {

    //匿名的对象表达式(直接实现接口；和Java中的你们对象一致，使用lambda表达式一样)
    val flight = object : Flight() {
        override fun fly(name: String) {
            println("sub name is $name")
        }

        override fun eat(food: String) {
            println("sub $food")
        }
    }
    flight.fly("angelo")
    flight.eat("fish")

    //具名的对象表达式(先使用类对接口进行实现，然后创建子类对象)
    val subFlight = SubFlight()
    subFlight.fly("making")
    subFlight.eat("rice")

    //todo java中的对象表达式(两种写法)
    //简洁版本(Runnable:接口名称；{}：就是实现Runnable接口的run方法；和Java中 ()->{}的方式是一样的；)
    var obj = Runnable { println("简洁版本的run") }

    //Java中的表达式-对象表达式
    var obj2 = object : Runnable {
        override fun run() {
            println("我是对象表达式中的run")
        }
    }
    //todo kt中的对象表达式（只有一种写法）
    var objKt = object : RunnableKT {
        override fun run() {
            println("kt中的run")
        }
    }
    //简易写法不行
//    var objKt2 = RunnableKT{ println("xxx")}


}

interface RunnableKT {
    open fun run();
}

//子类
class SubFlight() : Flight() {
    override fun fly(name: String) {
        println("具名：$name")
    }

    override fun eat(food: String) {
        println("具名：$food")
    }
}

//父类
open class Flight {
    open fun fly(name: String): Unit {
        println("name is $name")
    }

    open fun eat(food: String): Unit {
        println("the food is $food")
    }
}