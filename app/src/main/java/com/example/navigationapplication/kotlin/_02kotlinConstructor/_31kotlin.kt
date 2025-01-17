package com.example.navigationapplication.kotlin._02kotlinConstructor

/**
 * author: Angelo.Luo
 * date : 12/29/2023 11:03 AM
 * description:
 */

// todo 主构造器初始化，主次构造器执行顺序
fun main() {
    val o = _31kotlin("angelo", 24)//次构造器
    o.show()
    _31kotlin("", "I need your approval")
}

//主构造器（形参没有添加var、val那么就是临时的变量，在其他地方不能直接使用，但是在init中可以使用）
//todo 调用次构造器的执行顺序：第一步：info的赋值
class _31kotlin(name: String, var info: String) {

    //todo 第二步（类的成员变量和init是同时生成的，只是因为这个在init的前面，所以先执行了它，再执行init）
    var nameUser = name

    //这里是主构造器初始化的代码
    //todo 第三步
    init {
        println("init name is ${name} info is ${info}")
        //如果括号里面是false：那么执行匿名函数里面的逻辑；true：无任何操作（false:执行{}里面的操作）
        require(name.isNotBlank()) {
            //（）里面的值为false抛出异常
            "name是为空值，这样是不可以的!"
        }
    }

    //此构造器（必须继承主构造器；目的：为了主构造器统一管理，为了更好的初始化设备）
    //todo 第四步
    constructor(name: String = "李元霸", age: Int = 23) : this(name, "thanks") {
        //次构造器中的变量只是属于次构造器的局部变量，不能当作类的成员变量，所以在次构造器的外部无法发使用
        println("name = [${name}], age = [${age}]")
    }

    constructor(
        name: String = "李元吉",
        age: Int = 34,
        info: String = "i have applied for the installing of some software"
    ) : this(name, "approval") {
        //次构造器中的变量只是属于次构造器的局部变量，不能当作类的成员变量，所以在次构造器的外部无法发使用
        println("name = [${name}], age = [${age}], info = [${info}]")
    }

    fun show(){
        println("show nameUser = [${nameUser}], info = [${info}]")
    }
}

