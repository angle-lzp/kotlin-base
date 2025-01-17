package com.example.navigationapplication.kotlin._03kotlinClass

import com.example.navigationapplication.kotlin._05annotation.show

/**
 * author: Angelo.Luo
 * date : 12/29/2023 11:03 AM
 * description:
 */

// todo 对象声明    object修饰的类是 单例的；是单例的话里面的方法属性可以直接通过类名调用，不需要创建实例，Kotlin也不允许创建对象实例
fun main() {
    println(ObjClass)
    println(ObjClass)
    println(ObjClass)
    println(ObjClass)
    println(ObjClass)
    println(ObjClass)

    ObjClass.show()

    //ObjClass()    //编译不通过

}

object ObjClass {

    fun show() {
        println("approval")
    }
}