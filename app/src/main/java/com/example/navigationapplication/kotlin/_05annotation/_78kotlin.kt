package com.example.navigationapplication.kotlin._05annotation

/**
 * author: Angelo.Luo
 * date : 01/04/2024 4:14 PM
 * description:
 */
//todo 注解：

class Other {
    companion object {
        var info = "angeloInfo"

        //会把字段放到Companion类的外面，Java代码可以直接通过Other.name调用
        @JvmField
        var name = "making"

        //没有加的话就是一个普通的方法，非静态方法：进行Other.Companion.show()
        fun show() {
            println("other angelo")
        }

        //会把方法放到Companion类的外面，Java代码可以直接通过Other.print()调用
        //注解的含义：将这个方法变成静态方法
        @JvmStatic
        fun print(){
            println("print")
        }
    }

    fun eat(){

    }
}