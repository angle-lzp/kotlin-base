package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo vararg关键字（多参数的传递）

//objects:现在是一个临时的输入类型，现在不能用，需要在下面重写赋值才可以用
class _55kotlin<T>(vararg objects: T, var isMap: Boolean) {

    //在这里重新赋值
    //使用out的含义：只能读取不能修改
    //1.objectArray: Array<out T>
    private val objectArray: Array<out T> = objects;

    //takeIf:如果isMap是true返回objectArray[index]的值，反之：返回null
    //2.showObj(index: Int):通过索引获取数据
    fun showObj(index: Int): T? = objectArray[index].takeIf { isMap }

    //3.mapObj(index, lambda表达式)
    fun <O> mapOjb(index: Int, mapAction: (T?) -> O) =
        mapAction(objectArray[index].takeIf { isMap })

    override fun toString(): String {
        return "_55kotlin(isMap=$isMap, objectArray=${objectArray.contentToString()})"
    }
}

fun main() {
    //由于使用了 太多的类型组合，下面p1的类型应该更改是：_55kotlin<Comparable<*> & java.io.Serializable}>
    //但是上面是不允许这样写的，可以使用基类Any _55kotlin<Any>
    //1.
    val p1 = _55kotlin("angelo", 23, true, 20.3f, 34.456, null, 'c', isMap = true);
    println(p1.showObj(0))
    println(p1.showObj(1))
    println(p1.showObj(2))
    println(p1.showObj(3))
    println(p1.showObj(4))
    println(p1)

    //it的类型 实际上真正的类型 {Comparable<*> & java.io.Serializable}
    //可以对里面的元素进行操作
    //2.
    val length = p1.mapOjb(0) {
        it.toString().length
    }
    println(length)
}