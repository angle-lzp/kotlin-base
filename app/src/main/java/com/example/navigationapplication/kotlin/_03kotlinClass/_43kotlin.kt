package com.example.navigationapplication.kotlin._03kotlinClass

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */

//todo 数据类 copy方法的注意情况
fun main() {

    println(ResponseResult1("angelo", "123456", "什么都没有"))//使用的是Any的toString方法，所以输出类地址
    println(ResponseResult2("angelo", "123456", "什么都没有"))//使用的是重写后的toString

    //这里使用的是Any的equals方法，没有重写，那就是引用比较
    println(
        ResponseResult1("angelo", "123456", "什么都没有") == ResponseResult1(
            "angelo",
            "123456",
            "什么都没有"
        )
    )

    //todo copy方法的注意事项
    var p1 = ResponseResult3("Luo", "678876", "no", "data")
    println(p1)
    println(p1.info)

    //数据类里边重写的copy方法，里边是通过构造器重写new了一个对象的，是只携带主构造器中的参数，不携带次构造器中的参数的
    //需要注意下
    var newP1 = p1.copy("steven", "345768", "copy")
    println(newP1)
}


//普通类：只会生成set、get方法；继承了Any基类（默认的equals是引用类型的比较）
class ResponseResult1(var userName: String, var password: String, var info: String)

//数据类：生成set、get方法，构造函数、结构操作、copy，重写基类Any的toString，hashCode,equals方法
data class ResponseResult2(var userName: String, var password: String, var info: String)

//数据类：生成set、get方法，构造函数、结构操作、copy，重写基类Any的toString，hashCode,equals方法
data class ResponseResult3(var userName: String, var password: String, var info: String) {

    var otherInfo: String = ""

    constructor(
        userName: String,
        password: String,
        info: String,
        other: String
    ) : this("LiMi", "000000", "No Data!") {
        println("次构造器")
        this.otherInfo = other
    }

    override fun toString(): String {
        return "ResponseResult3(userName=$userName, password=$password, info=$info, other=$otherInfo)"
    }
}



