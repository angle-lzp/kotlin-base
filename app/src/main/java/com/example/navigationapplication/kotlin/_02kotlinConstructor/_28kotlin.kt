package com.example.navigationapplication.kotlin._02kotlinConstructor

/**
 * author: Angelo.Luo
 * date : 12/29/2023 11:03 AM
 * description:
 */

// todo 主构造函数学习
fun main() {

    _28kotlin(_name = "angelo", _age = 23, _info = "冲冲冲").show()
    _028kotlin(name = "angelo", age = 23, info = "冲冲冲").show()

}

//主构造函数：规范来说，都是增加_xxx的方式，临时的输入类型，不能直接用，需要接收下来 成为变量才能用；
class _28kotlin(_name: String, _age: Int, _info: String) {

    var name = _name
        get() = field //get不允许私有化，所以在这里不能使用private
        private set(value) {
            field = value
        }

    val age = _age
        get() = field + 1
//        set(value) {      //val：只读，不能修改，不能使用set函数
//            field = value
//        }

    val info = _info
        get() = "[$field]"

    fun show() {
        println("数据展示：$name,$age,$info")
    }
}

//以后一般都是这样写的：加上var，这样的话就可以直接使用，一步到位
class _028kotlin(var name: String, var age: Int, var info: String) {

    fun show() {
        println("数据展示：$name,$age,$info")
    }
}