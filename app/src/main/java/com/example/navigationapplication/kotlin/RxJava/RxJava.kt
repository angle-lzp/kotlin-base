package com.example.navigationapplication.kotlin.RxJava

/**
 * author: Angelo.Luo
 * date : 01/04/2024 5:49 PM
 * description:手写RxJava，模仿RxJava
 */
fun main() {

    //%n：换行
    println(String.format("is %s%n%s", "angelo", "luo"))

    //输入
    val str: String? = readlnOrNull()
    println(str)

    create {
        "angelo"
    }.map {
        "[$this]"
    }.map {
        "@@$this@@"
    }.observer {
        println("this is $this")
    }

}

class RxJavaCoreClass<T>(var value: T)

inline fun <O> create(action: () -> O): RxJavaCoreClass<O> {
    return RxJavaCoreClass(action())
}

inline fun <I, O> RxJavaCoreClass<I>.map(action: I.() -> O): RxJavaCoreClass<O> {
    return RxJavaCoreClass(action(value))
}

inline fun <I> RxJavaCoreClass<I>.observer(action: I.() -> Unit): Unit {
    action(value)
}
