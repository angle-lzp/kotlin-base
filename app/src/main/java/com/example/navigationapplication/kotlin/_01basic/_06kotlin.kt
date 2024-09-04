package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/28/2023 10:54 AM
 * description:
 */

//todo 可空的情况下进行的安全操作：变量后面加？相当于是一种补救措施。使用：？
fun main() {

    var str : String? = null;

    str = "angelo";

    //str.capitalize() //会给出提示，说要给出补救机制（因为str可能是null）

    //在变量后面加上？表示：如果str为空(null)那么就不执行后面的capitalize()方法，就不会引发空指针异常
    var capitalize = str?.capitalize()

    println(capitalize)

}