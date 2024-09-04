package com.example.navigationapplication.kotlin._03kotlinClass

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */

//todo 枚举（枚举里边也可以写函数）
fun main() {

    println(Week.星期一.ordinal) //ordinal:顺序 0
    println(Week.星期三)

    //todo 重点：枚举的值等于枚举本身
    println(Week.星期三 is Week)

    //todo 枚举的一般用法如下：
    //打印
    println(LimbsInfoEnum.LEFT_FOOT.limbsInfo)//打印对象调用的方法是toString
    println(LimbsInfoEnum.LEFT_FOOT.show())

    //修改数据
    LimbsInfoEnum.LEFT_FOOT.updateDate(LimbsInfo("左后2", 234))

    Toast.GREEN.color

}

//0，1，2，3...
enum class Week {
    星期一, 星期二, 星期三, 星期四, 星期五, 星期六, 星期日
}

data class LimbsInfo(var info: String, var length: Int) {}

//主构造器传一个LimbsInfo的信息，那么枚举的时候也必须传一个这样类型的入参对象。
enum class LimbsInfoEnum(var limbsInfo: LimbsInfo) {
    LEFT_HAND(LimbsInfo("右手", 50)),
    RIGHT_HAND(LimbsInfo("右手", 50)),
    LEFT_FOOT(LimbsInfo("右手", 50)),
    RIGHT_FOOT(LimbsInfo("右手", 50));

    //给出一个方法展示数据(以后需要取出数据的话，可以根据这样的来写)
    fun show() = "limbsInfo is ${this.limbsInfo.info},length is ${this.limbsInfo.length}"

    //给出修改数据的方法
    fun updateDate(limbsInfo: LimbsInfo) {
        //原来的数据
        println("原来的数据 is ${this.limbsInfo}");
        //进行数据修改
        this.limbsInfo.info = limbsInfo.info;
        this.limbsInfo.length = limbsInfo.length;

        //修改后的数据
        println("修改后的数据 is ${this.limbsInfo}")
    }
}

enum class Toast(val color: Int) {
    RED(1),
    GREEN(2)
}