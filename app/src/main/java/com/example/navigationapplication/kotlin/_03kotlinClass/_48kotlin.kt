package com.example.navigationapplication.kotlin._03kotlinClass

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */

//todo 枚举：密封类(sealed修饰的类)
fun main() {
    println(CheckData2(DataEnum2.DATA2).show())
    println(CheckData2(DataEnum2.DATA4("马原")).show())

    println(DataEnum2.DATA1 === DataEnum2.DATA1)

}

//加上：sealed 修饰class 就是密封类
//密封类里面的数据就需要类型符来修饰了
//sealed：密封类表示一种有限的可能，里面的东西是有限的；用在when中，else都可以不用
sealed class DataEnum2 {
    /**
     * 加上了object那么这个类就是单例的
     * 在这里需要继承主构造函数
     */
    object DATA1 : DataEnum2();
    object DATA2 : DataEnum2();
    object DATA3 : DataEnum2();
    class DATA4(val userName: String) : DataEnum2()
}

class CheckData2(private val dataEnum: DataEnum2) {
    fun show() = when (dataEnum) {
        is DataEnum2.DATA1 -> "数据1"
        is DataEnum2.DATA2 -> "数据2"
        is DataEnum2.DATA3 -> "数据3"
        is DataEnum2.DATA4 -> "数据4-》${(this.dataEnum as DataEnum2.DATA4).userName}"
    }
}