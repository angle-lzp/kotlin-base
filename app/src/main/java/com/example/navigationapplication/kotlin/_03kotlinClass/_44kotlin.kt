package com.example.navigationapplication.kotlin._03kotlinClass

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */

//todo 解构申明
fun main() {
    var (v1, v2) = Student01("angelo", "123456")
    println("v1 = $v1,v2 = $v2")
}

class Student01(var userName: String, var password: String) {

    //解构申明：注意事项：component0必须是component1，component2和成员一一对应，顺序下来
    //todo 结构就是在当前类中使用下面的操作接收入参的数据,然后在其他地方使用的时候可以通过var(v1,v2)
    //todo 这样的形式使用
    operator fun component1() = userName;
    operator fun component2() = password;
}



