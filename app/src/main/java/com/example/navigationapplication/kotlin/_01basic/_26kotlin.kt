package com.example.navigationapplication.kotlin._01basic

/**
 * author: Angelo.Luo
 * date : 12/29/2023 8:23 AM
 * description:
 */

//todo 集合：map：不可变map和可变map
fun main() {

    funVariableMap()
//    funNotVariableMap()
}

private fun funVariableMap(): Unit {
    val mutableMap = mutableMapOf(Pair("lucy", 89), Pair("make", 34))
    //使用+= -+的方式
    mutableMap += "angelo" to 34
    mutableMap -= "make"
    mutableMap += Pair("leno", 24)

    //添加方式
    mutableMap.put("alan", 80)
    mutableMap["mia"] = 34//推荐使用这种方式

    //如果Steven的key不存在，那么就添加Pair("steven",999)到map里边，并返回Steven的值；存在：直接返回Steven的值
    val value = mutableMap.getOrPut("steven") { 999 }

    //如果不存在返回null
    println("=============${mutableMap["cccc"]}")


    println(value)
}
/**
 * 不可变map
 */
private fun funNotVariableMap(): Unit {
    //todo 创建
    //创建方式一：
    val map: Map<String, Int> = mapOf("lucy" to 23, "tom" to (98))
    //创建方式二：
    val map02: Map<String, Int> = mapOf(Pair("tom", 87), Pair("lucy", 23))
    println(map02)


    println(map02.values.joinToString(separator = "+", prefix = "+") {
        it.toString()
    })

    //todo 查询
    //查询方式一：
    println(map.get("lucy"))//等价如下["lucy"]的格式 找不到返回null
    println(map["tom"])
    //查询方式二：
    println(map.getOrDefault("making", -999))
    //查询方式三：
    println(map.getOrElse("making") { -111 })
    //查询方式四：Java的方式，找不到会抛出异常(用起来人会崩溃)
    //println(map.getValue("making"))

    //todo 遍历
    //方式一：
    map.forEach {
        //此时的it:Map.Entry<String,Int>
        println("key:${it.key},value:${it.value}")
    }

    //方式二：
    map.forEach { key: String, value: Int ->
        println("key:$key,value:$value")
    }

    //方式三：
    map.forEach { (key, value) ->
        println("key:$key,value:$value")
    }

    //方式四：
    for (entry: Map.Entry<String, Int> in map.entries) {
        println("key:${entry.key},value:${entry.value}")
    }
}
