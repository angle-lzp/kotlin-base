package com.example.navigationapplication.gson

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * author: Angelo.Luo
 * date : 01/10/2024 5:08 PM
 * description:
 */

fun main() {
    val gson = Gson()
    //json->对象
    val jsonStr01 = "{\"nameUser\":\"angelo\",\"password\":\"123456\",\"age\":23}"
    var fromJson01 = gson.fromJson(jsonStr01, Account::class.java)
    println("01-json->对象：$fromJson01")

    //对象->json
    val obj01 = Account()
    val jsonStr02 = gson.toJson(obj01)
    println("02-对象->json：$jsonStr02")

    //集合对象->json
    val list = listOf(obj01, obj01, obj01)
    val listJson01 = gson.toJson(list)
    println(listJson01)

    //集合json->集合对象
    val listJson02 =
        "[{\"nameUser\":\"angelo\",\"password\":\"123456\",\"age\":23},{\"nameUser\":\"angelo\",\"password\":\"123456\",\"age\":23},{\"nameUser\":\"angelo\",\"password\":\"123456\",\"age\":23}]"
    var listJson = gson.fromJson<Any>(listJson02, object : TypeToken<List<Account>>() {}.type)
    println(listJson)

    //todo JsonToKotlin插件，将json生成对应的kotlin的class

}

open class Account {
    var nameUser: String = "angelo"
    var password: String = "123456"
    var age: Int = 23
    override fun toString(): String {
        return "Account(nameUser='$nameUser', password='$password', age=$age)"
    }
}