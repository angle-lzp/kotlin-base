package com.example.navigationapplication.kotlin._02kotlinConstructor

/**
 * author: Angelo.Luo
 * date : 12/29/2023 11:03 AM
 * description:
 */

// todo 构造函数默认参数
fun main() {
    _30kotlin("angelo", 24)
    _30kotlin("cooper", 23, "i need you approval")

    //当主、次函数都有默认数据的时候调用的是主函数
    println(_30kotlin().name)

    println(AAA().toString())

    println(_30kotlin())
}

//主构造器
class _30kotlin(var name: String = "李世民") {

    //次构造器（必须继承主构造器；目的：为了主构造器统一管理，为了更好的初始化设备）
    constructor(name: String = "李元霸", age: Int = 23) : this(name) {
        println("name = [${name}], age = [${age}]")
    }

    constructor(
        name: String = "李元吉",
        age: Int = 34,
        info: String = "i have applied for the installing of some software"
    ) : this(name) {
        println("name = [${name}], age = [${age}], info = [${info}]")
    }

    override fun toString(): String {
        return "_30kotlin(name='$name')"
    }


}

class AAA {

}

