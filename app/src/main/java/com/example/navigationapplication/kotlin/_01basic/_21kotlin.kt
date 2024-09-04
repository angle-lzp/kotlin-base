package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/29/2023 8:23 AM
 * description:
 */

//todo 集合类：List：可变list、不可变list
fun main() {
//    funList();
//    funMutableList();
//    funMutatorFeature();
    funErgodic();
}

/**
 * 遍历
 */
private fun funErgodic() {
    val list = listOf(1, 2, 8, 3, 345, 5, 6)

    //方式一：
    for (item in list) {
        print("元素：$item ")
    }
    println()
    //方式二：
    list.forEach {
        print("元素：$it ")
    }

    println()
    //方式三：
    list.forEachIndexed { index: Int, item: Int -> print("下标：$index 元素：$item; ") }
}

/**
 * List
 */
private fun funList(): Unit {

    //todo 这样创建的是不可变的
    var list: List<String> = List(3) {
        it.toString()
    }
    //老版的取出list的数据，会出现空指针异常
    println(list[0])
    println(list[1])
    println(list[2])
    //println(list[3])


    //todo 推荐实用下面的方式，可以避免空指针异常
    val list1: List<String> = listOf("angelo", "steven", "tom", "andrew")//todo 这样创建的是不可变的
    println(list1.getOrElse(7) {
        "索引越界了！"
    })
    println(list1.getOrNull(8) ?: "还是索引越界了！")
}

/**
 * 可变集合
 */
private fun funMutableList(): Unit {
    //todo 可变
    val list: MutableList<String> = MutableList(3) { index: Int ->
        index.toString()
    }
    list.add("angelo")
    println(list)
    list.remove("1")
    println(list)
    list.add("ccc")

    //todo 可变
    val list1: MutableList<String> = mutableListOf("making", "angelo", "leon", "steven")
    list.forEach { println(it) }
}

/**
 * 可变-》不可变
 * 不可变-》可变
 */
private fun funListToConvent() {
    //todo 不可变->可变
    val list = listOf("angelo")
    var mutableList = list.toMutableList()
    mutableList.add("url")
    mutableList.remove("url")


    //todo 可变->不可变
    val list1 = mutableListOf("angelo")
    var toList = list1.toList()
}

/**
 * Mutator:特性；+= ，-=
 * removeIf
 */
private fun funMutatorFeature() {

    //todo -= +=
    val list = mutableListOf("angelo", "make")
    list += "steven"
    list -= "make"
    println(list)

    //todo removeIf
    list.removeIf { it: String -> it.contains("t") }
    println(list)
}