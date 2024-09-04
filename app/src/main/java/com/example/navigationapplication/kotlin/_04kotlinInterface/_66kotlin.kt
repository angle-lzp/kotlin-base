package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo let 和 apply 源码
fun main() {

    "".let {

    }
    "".run {

    }
    "".apply {

    }
    "".also {

    }

    val str = "angelo"
    "aaa".also {

        str.let {

        }

    }
    str.myLet {
        it.length
    }.myLet {
        if (it > 5) {
            "长度大于：5"
        } else {
            "长度小于：5"
        }
    }.myLet {
        println(it)
    }

    str.myApply {
        println(length)
    }.myApply {
        println(this)
    }.myApply {
        println(toCharArray(0, length).toList().shuffled().first())
    }
}

/**
 * 高阶函数：在函数的入参里边又包含了函数，这个称为高阶函数
 */
//自定义：myApply
//高阶函数建议inline关键字来修饰
//private：私有
//fun <E>：函数中申明一个泛型
//E.myApply：让所有类型的数据都可以 xxx.myApply调用；泛型扩展
//E.()->Unit：让我们的匿名函数里面持有this，在lambda里面不需要返回值，因为永远返回的是E本身

private inline fun <E> E.myApply(lambda: E.() -> Unit): E {//函数里面是this
    lambda()
    return this
}

//自定义：myLet;函数里面是it
private inline fun <T, E> T.myLet(lambda: (T) -> E): E {
    return lambda(this)
}

private inline fun <T> T.myAlso(lambda: (T) -> Unit): T {
    lambda(this)
    return this;
}