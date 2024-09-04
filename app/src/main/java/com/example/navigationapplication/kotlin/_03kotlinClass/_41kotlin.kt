package com.example.navigationapplication.kotlin._03kotlinClass

/**
 * author: Angelo.Luo
 * date : 12/29/2023 11:03 AM
 * description:
 */

// todo 伴生对象
/**
 * 伴生对象的由来：在KT中没有像Java中的static静态的东西，伴生对象很大程度上和Java的static静态很相似
 * 无论CompaniesClass()构建多少次，伴生对象只会加载一次
 * CompaniesClass.fun01()调用多少次，伴生对象也只会加载一次
 * 只会初始化一次
 */
fun main() {
    //背后的代码 System.out.println(CompaniesClass.Companion.getName())
    println(CompaniesClass.name)
    CompaniesClass.fun01()
}

class CompaniesClass {

    //todo
    companion object {
        val name: String? = "angelo"
        fun fun01() {
            println("fun01")
        }
    }
}