package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo 集合类的变换函数-flatMap
fun main() {

    //map：最后一行返回一个元素放到集合中，最后一行返回的是什么类型那这个集合就是什么类型
    //flatMap：最后一行返回一个完整的集合，然后再放到一个新的集合中（集合里边放集合List<List<T>>）,但是最后返回来的是一个List<T>,没有嵌套集合
    val list = listOf("angelo", "steven", "javan", "cooper")

    val flatMapList = list.flatMap {
        //区别：这里返回集合
        listOf("new is $it", "new2 is $it")
    }
    val mapList = list.map {
        //区别：这里返回元素
        it
    }

    println(flatMapList.size)
    println(flatMapList)

}