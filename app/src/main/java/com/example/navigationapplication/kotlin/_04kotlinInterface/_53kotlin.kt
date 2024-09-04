package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo 泛型

//案例1：
class PrintlnCls<T>(private val data: T) {
    fun show() = println("打印的数据是：$data")

    fun <R> show1(data: R): R {
        println("我也不知道这是个啥子：$data")
        return data
    }
}

data class Student(val userName: String, val age: Int, val sex: Char) {
    init {
        println("初始化了！")
    }
}

fun main() {
    val student: Student = Student("angelo", 24, '男')
    PrintlnCls(student).show()

    PrintlnCls(student).show1(student)

    PrintlnCls("什么东西").show()
}