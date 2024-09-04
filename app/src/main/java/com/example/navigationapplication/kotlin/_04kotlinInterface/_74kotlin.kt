package com.example.navigationapplication.kotlin._04kotlinInterface

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//单例模式
fun main() {
//    SingletonClass.show()
//    SingletonClass.show()

//    println(SingletonLazyClass.getInstanceObj())
//    println(SingletonLazyClass.getInstanceObj())
//    println(SingletonLazyClass.getInstanceObj())
//    println(SingletonLazyClass.getInstanceObj())
//    println(SingletonLazyClass.getInstanceObj())
//    println(SingletonLazyClass.getInstanceObj())

    runBlocking {
        val job = launch(Dispatchers.Default) {
            repeat(100) {
                for (i in 1..100) {
                    println(SingletonLazyClass.getInstanceObj())
                }
            }
        }
        job.join()
    }


    SingletonLazyClass02.instance.show()
}

//1.饿汉式：加上object就是一个实打实的单例
object SingletonClass {
    fun show() {
        println("object is $this")
    }
}

//2.单例模式：懒汉式
class SingletonLazyClass {
    companion object {
        private var instance: SingletonLazyClass? = null
            get() {
                if (field == null) {
                    field = SingletonLazyClass()
                }
                return field
            }

        @Synchronized
        fun getInstanceObj(): SingletonLazyClass? {
            return instance!!
        }
    }
}

//2.单例模式：懒汉式
class SingletonLazyClass02 {
    companion object {
        val instance: SingletonLazyClass02 by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { SingletonLazyClass02() }
    }

    fun show(): Unit = println("SingletonLazyClass02")
}