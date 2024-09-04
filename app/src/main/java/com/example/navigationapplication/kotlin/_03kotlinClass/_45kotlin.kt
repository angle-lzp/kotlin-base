package com.example.navigationapplication.kotlin._03kotlinClass

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */

//todo 运算符重载
fun main() {
    //在没有实现重载的时候把光标放到这个 + 上会给出很多重载的方法可以看看
    println(AddClass(1, 1) + AddClass(2, 2))

}

data class AddClass(var number1: Int, var number2: Int) {

    //进行运算符的重载
    operator fun plus(p1: AddClass): Int {
        return (number1 + p1.number1) + (number2 + p1.number2)
    }

    //通过下面的操作，. 一下就可以查看哪些运算符可以重载
//    operator fun AddClass.


}




