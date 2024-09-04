package com.example.navigationapplication.kotlin._03kotlinClass

/**
 * author: Angelo.Luo
 * date : 12/29/2023 11:03 AM
 * description:
 */

// todo 内部类、嵌套类(内联类)

class InnerClass(_name: String) {

    /**
     * 加了inner的才算是内部类：
     * 内部类 可以访问 外部类的 变量和方法
     * 外部类 可以访问 内部类的 变量和方法
     */
    val name = _name

    inner class InnerClass01() {

        val innerName = name

        fun funInner01() {
            fun01()
            val inner01Name = name
        }

        inner class InnerClas02() {
            val inner02Name = name
        }
    }

    fun fun01() {
        println("name = $name")
    }

    fun fun02() {
        //外部类访问内部类方法
        InnerClass01().funInner01()

        //外部类访问内部类变量
        println(InnerClass01().innerName)
    }
}

/***
 * 内联类：没有加inner的就是内联类
 * 内部类 不可以访问 外部类的 变量和方法
 * 外部类 可以访问 内部类的 变量和方法
 *
 */
class NoInnerClass(_name: String) {
    val name = _name
    fun noInnerClassFun() {

        val n01 = NoInner01().name01
        NoInner01().fun01()

    }

    class NoInner01() {

        val name01 = "angelo"

        fun fun01() {
            println("cccc")
        }

    }
}

fun main() {
    println(P("angelo", "angelo").password)
    P("angelo", "angelo").name = "ccc"

}

data class P(var name: String, var password: String) {
}