package com.example.navigationapplication.kotlin._03kotlinClass

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */

//todo 枚举：代数数据类型
fun main() {
    println(CheckData(DataEnum.DATA3).show())
}

enum class DataEnum {
    DATA1, DATA2, DATA3;
}

class CheckData(private val dataEnum: DataEnum) {
    fun show() = when (dataEnum) {
        DataEnum.DATA1 -> "数据1"
        DataEnum.DATA2 -> "数据2"
        DataEnum.DATA3 -> "数据3"
        //else -> "";由于我们使用了show函数，是使用的枚举类型来对比的，这个就属于代数数据类型，就不需要写 else 了
        //因为when表达式是非常的明确的，是枚举，只有三个数据，没有其他的了（只会知道这个数据只有三个数据）
    }
}