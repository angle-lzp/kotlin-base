package com.example.navigationapplication.kotlin._04kotlinInterface

import java.io.File

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo DSL（领域专用语言（Domain Specified Language/DSL ））
fun main() {

    val res = Context().apply2 {
        println("it is $it,this is $this")
        println("name is $name")
        //不管最后一行返回什么时候，后面返回的都是this
    }
    println(res.name)

    println()

    val file = File("C:\\Applications\\a.txt").applyFile { name: String, length: String? ->
        println("name is $name,length is $length")
    }.applyFile { name, length ->
        println("看看是个啥子：$name,$length,this is $this")
    }
    println(file)

}

class Context {
    val info = "my name is angelo"
    val name = "context"

    fun showText(value: String) {
        println("value = [${value}]")
    }
}

/**
 * myApply：就是一个DSL的编程规范，定义输入输出等规则；（具体的myApply的具体实现交给用户去实现）
 * 输入：必须是context这个类才有资格调用没有Apply这个函数，匿名函数里面持有 it 和 this
 * 输出：始终返回context本身，所以方便使用链式编程
 * 然后main函数里边可以根据DSL编程方式标准规则来写具体的实现，这就是DSL编程规范
 */
//Context.(String)：this是Context，it是String(就是info的信息)
fun Context.apply2(myApply: Context.(String) -> Unit): Context {
    myApply(info)
    return this
}

fun File.applyFile(applyFileShow: File.(String, String?) -> Unit): File {
    setReadable(true)
    setWritable(true)
    setExecutable(true)
    applyFileShow(name, readLines()[0])
    return this
}