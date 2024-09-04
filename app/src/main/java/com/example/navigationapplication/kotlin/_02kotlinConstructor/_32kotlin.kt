package com.example.navigationapplication.kotlin._02kotlinConstructor

/**
 * author: Angelo.Luo
 * date : 12/29/2023 11:03 AM
 * description:
 */

// todo 延迟加载：需要手动进行加载
fun main() {

    var p = _32kotlin()
//    p.initResponseInfo()
    p.show()
}

class _32kotlin() {

    //不用val：因为后面是需要赋值，val是不能修改的；
    //todo lateinit：表示延迟加载的意思,需要自己手动进行加载
    lateinit var responseInfo: String

    //手动进行加载
    fun initResponseInfo() {
        responseInfo = "you already init"
    }

    fun show() {
        if (::responseInfo.isInitialized) {
            println(responseInfo)
        } else {
            println("you didn`t initializer")
        }
    }

}

