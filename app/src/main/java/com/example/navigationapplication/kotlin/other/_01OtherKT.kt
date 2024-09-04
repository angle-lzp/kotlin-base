package com.example.navigationapplication.kotlin.other

/**
 * author: Angelo.Luo
 * date : 01/23/2024 4:25 PM
 * description:额外的一些案例
 */
fun main() {

//    m01()
    m02()
//    m03()
    Car.userName = "lucy"
    println(Car.userName)
}

/**
 *
 */
private fun m01() {
    val num: Int = 20
    println(num.inc())//加一
    println(num.inv())//加一取反

    println(num.dec())//减一
}

private fun m02() {
    var value = readlnOrNull()
    println(value)

    val num = readlnOrNull()?.toIntOrNull()
    println(num)

}

private fun m03() {
    val strLength: (String) -> Int = {
        it.length
    }

    println(strLength("angelo"))
}

class Car {
    val wheels = listOf<String>()

    companion object {
        var userName = "angelo"
    }
}