package com.example.navigationapplication.kotlin._03kotlinClass

import com.example.navigationapplication.kotlin._05annotation.show

/**
 * author: Angelo.Luo
 * date : 12/29/2023 11:03 AM
 * description:
 */

// todo 对象声明    object修饰的类是 单例的
fun main() {
    println(ObjClass)
    println(ObjClass)
    println(ObjClass)
    println(ObjClass)
    println(ObjClass)
    println(ObjClass)

    ObjClass.show()

}

object ObjClass {

    fun show() {
        println("approval")
    }
}