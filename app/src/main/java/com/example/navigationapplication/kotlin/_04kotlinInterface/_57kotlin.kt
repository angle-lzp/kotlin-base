package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */

//todo out-协变(结合泛型一起使用)
interface Producer<out T> {
    //out:加了out的泛型类型，表示这个数据只能读，不能修改；
    fun get(): T

//    fun set(data:T?); //直接编译不通过；
}

//todo in-逆变
interface Consumer<in T> {
    //in:加了in的泛型类型，表示这个数据只能写，不能读；
//    fun get():T?; //这是读取：编译直接不通过

    fun set(data: T);
}

//默认情况out,in没有加：读和写都可以；
interface ProducerConsumer<T> {
    fun get(): T
    fun set(data: T)
}

class ProducerClass01 : Producer<Animal> {
    override fun get(): Animal {
        println("producer is Animal")
        return Animal()
    }
}

class ProducerClass02 : Producer<Man> {
    override fun get(): Man {
        println("producer is Wan")
        return Man()
    }
}

class ProducerClass03 : Producer<Woman> {
    override fun get(): Woman {
        println("producer is Woman")
        return Woman()
    }
}

class ConsumerClass01 : Consumer<Animal> {
    override fun set(data: Animal) {
        println("我设置了Animal：$data")
    }
}


class ConsumerClass02 : Consumer<Humanity> {
    override fun set(data: Humanity) {
        println("我设置了Humanity：$data")
    }
}


class ConsumerClass03 : Consumer<Man> {
    override fun set(data: Man) {
        println("我设置了Man：$data")
    }
}

class ConsumerClass04 : Consumer<Humanity> {
    override fun set(data: Humanity) {
        println("我设置了Humanity：$data")
    }
}


open class Animal
open class Humanity : Animal()
open class Man : Humanity()
open class Woman : Humanity()

fun main() {
    //1，其实里边的out，其实就是<T extends Animal>(是T继承Animal，是Animal的子类) Animal相当于其他类的父类；子类作为类型，那父类作为泛型肯定是可以的；
    //右边类型是左边类型的子类
    val p1: Producer<Animal> = ProducerClass01()
    val p2: Producer<Animal> = ProducerClass02()
    val p3: Producer<Animal> = ProducerClass03()

    println()

    //2.其实里边的in，<T super ?>(接收的类型是T的父类就可以),右边的类型是左边类型的父类
    val c1: Consumer<Animal> = ConsumerClass01()
    val c2: Consumer<Man> = ConsumerClass02()
    val c3: Consumer<Man> = ConsumerClass03()
    val c4: Consumer<Woman> = ConsumerClass04()

}