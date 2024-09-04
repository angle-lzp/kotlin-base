package com.example.navigationapplication.kotlin._02kotlinConstructor

/**
 * author: Angelo.Luo
 * date : 12/29/2023 11:03 AM
 * description:
 */

// todo 初始化陷阱（主要是代码的执行顺序，从上往下执行的；前面用的变量在后面定义会抛出异常）
fun main() {

    println(_343kotlin("angelo").info)

}

//todo 执行顺序问题
class _343kotlin(_name: String) {

//    val name = _name;//放在这里就没有问题

    val info: String = fun01();

    val name = _name;//name赋值放在这里是有问题的；在上面调用fun01()的时候，name还没有初始化

    fun fun01(): String {
        return name[0].toString()
    }

}

//todo 顺序问题
class _34kotlin() {

    init {
        //直接编译不通过，提示未初始化
//        println(name)
    }

    var name: String? = "lucy";
}

//todo 顺序问题
class _342kotlin() {

    var name: String? = null

    init {
        fun01()
        name = "angelo"
    }

    fun fun01() {
//        println(name[0])
    }
}