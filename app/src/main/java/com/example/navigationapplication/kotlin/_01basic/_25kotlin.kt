package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/29/2023 8:23 AM
 * description:
 */

//todo 数组：Array
fun main() {

    /*  ByteArray;
        ShortArray
        CharArray
        IntArray
        FloatArray
        DoubleArray
        LongArray
        BooleanArray
        Array*/

    //创建(数组长度不可变)
    val intArr: IntArray = intArrayOf(1, 2, 3)
    println(intArr)

    println(intArr[0])

    //数组查看
    println(intArr.elementAt(0))
    println(intArr.elementAtOrElse(100) { -1 })
    println(intArr.elementAtOrNull(100) ?: "索引越界了!")

    //list转数组
    val list: List<String> = listOf("make", "lucy", "tom")
    var toTypedArray: Array<String> = list.toTypedArray()
    toTypedArray.forEach { println("$it") }
    println(toTypedArray)


    val arr = IntArray(3) { 9 }
    println(arr.contentToString())

}
