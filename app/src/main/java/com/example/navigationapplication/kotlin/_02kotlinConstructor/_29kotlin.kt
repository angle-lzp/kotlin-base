package com.example.navigationapplication.kotlin._02kotlinConstructor

/**
 * author: Angelo.Luo
 * date : 12/29/2023 11:03 AM
 * description:
 */

// todo 次构造函数学习
fun main() {
    _29kotlin("angelo", 24)
    _29kotlin("cooper", 23, "i need you approval")
}

//主构造器
class _29kotlin(var name: String) {

    //此构造器（必须继承主构造器；目的：为了主构造器统一管理，为了更好的初始化设备）
    constructor(name: String, age: Int) : this(name) {
        println("name = [${name}], age = [${age}]")
    }

    constructor(name: String, age: Int, info: String) : this(name) {
        println("name = [${name}], age = [${age}], info = [${info}]")
    }
}

