package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo reified

data class Object01(val name: String, val age: Int, val info: String)
data class Object02(val name: String, val age: Int, val info: String)
data class Object03(val name: String, val age: Int, val info: String)

class _58kotlin {
    //将所有的功能都写在函数上
    //<reified T>这中方式是用在方法上面的，Java是：<T>是一样的
    inline fun <reified T> randomDefault(defaultLambdaAction: () -> T): T {
        val objList: List<Any> = listOf(
            Object01("obj01 angelo", 22, "obj01"),
            Object02("obj02 steven", 22, "obj02"),
            Object03("obj03 javins", 22, "obj03")
        )

        val randomObj : Any? = objList.shuffled().first()

        println("随机产生的对象为：$randomObj")
        //如果randomObj的类型不是T的类型，那么返回null；最后返回默认值；
        //在这里面如果需要用到T的话，那么就得在方法上加上reified关键字来修饰T（可以尝试把这个reified去掉看看）
        return randomObj.takeIf { randomObj is T } as T? ?: defaultLambdaAction()
    }
}

fun main() {
    //在这里的话需要指明T的类型是啥子哦
    val res: Object01 = _58kotlin().randomDefault<Object01> {
        println("我返回的是一个默认对象")
        Object01("obj01--angelo", 28, "angelo--")
    }
    println(res)
}