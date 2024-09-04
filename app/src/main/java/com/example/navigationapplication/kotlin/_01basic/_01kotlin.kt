package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/27/2023 5:03 PM
 * description:
 */

//Any
fun main() {
    val length: Int = "Angelo".count();
    println(length);

    val count: Int = "Angelo".count() {
        //it是显隐式的
        it == 'n'
    }
    println(count)

    val fun01: (Int, Int, Int) -> String = { num1, num2, num3 ->
        "num1=${num1},num2=${num2},num3=${num3}"
    }

    println(fun01(1, 2, 3))

    //在使用匿名函数的时候，如果只有一个入参那么会给这个参数名称隐式的设置为it（it就是这个参数的名称）
    val query: (String) -> String = {
        it
    }
    println(query("String"))

    val query2: (String, String) -> String = { it1, it2 ->
        it1 + it2
    }

    //匿名函数的类型推断
    //方法名称：必须指定 参数类型 和 返回类型
    //方法名 = 类型推断的返回类型
    val avg = { v1: Int, v2: String ->
        "$v1 : v1,$v2 : v2"
    }
    println(avg(12, "Str"))

    //todo 函数中的函数
    login("angelo", "123456") { _: String, _: Int ->
        "angelo"
    }

    //todo inline内联
    /**
     * 如果不使用内联的话那么会在函数的调用端生成多个对象来调用（会消耗性能）
     */
    login2("angelo", "098765") { _: String, _: Int ->
        "angelo"
    }
}

//todo 函数中的函数
fun login(userName: String, password: String, response: (String, Int) -> String): String {
    println("$userName -> $password -> ${response.toString()}")
    return "$userName -> $password -> $response"
}

//todo inline内联
inline fun login2(userName: String, password: String, response: (String, Int) -> String): String {
    println("$userName -> $password ->")
    return "$userName -> $password ->"
}