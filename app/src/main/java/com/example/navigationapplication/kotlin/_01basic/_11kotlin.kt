package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/28/2023 2:20 PM
 * description:
 */

//todo String类的相关方法
fun main() {

    //todo substring
    var str1: String = "angelo.Luo"
    println(str1.substring(1, 2))
    //等价上面的；建议用until这种（左闭右开）
    println(str1.substring(0 until 2))

    //todo split
    val str2: String = "angel,steven,javins,tom";
    var list = str2.split(",")
    println(list)

    //kotlin语言的解构
    var (v1, v2, v3, v4) = str2.split(",")
    println("v1=$v1,v2=$v2,v3=$v3,v4=$v4")

    //todo replace
    val str3: String = "abcdefghijlmnopqrstuvdxyz";
    val replace = str3.replace("abc", "123")
    println(replace)

    //[]：表示匹配任意字符,匹配上了然后将值进行替换
    val encodeStr = str3.replace(Regex("[abcd123\\]]")) {
        it.value
        when (it.value) {
            "a" -> "1"
            "b" -> "2"
            "c" -> "3"
            "d" -> "4"
            else -> it.value
        }
    }

    println("加密后：$encodeStr")


    val decodeStr = encodeStr.replace(Regex("[1234]")) {
        it.value
        when (it.value) {
            "1" -> "a"
            "2" -> "b"
            "3" -> "c"
            "4" -> "d"
            else -> it.value
        }
    }
    println("解密后：$decodeStr")
}
