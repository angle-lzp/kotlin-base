package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo 接口的默认实现

//接口
interface IUsb2 {
    //1.接口 var 也是不能给接口的成员赋值的（可以使用val，直接重写get方法）
    //2.任何类 接口 等等 val代表只读，是不可以在后面动态赋值的（但是可以重写get方法）
    val usbVersionInfo: String
        get() = (1..100).shuffled().last().toString()
    val usbInsertDevice: String
        get() = "什么设备的usb接口都有！"

    fun insertUsb(): String
}

class MouseUsb : IUsb2 {

    override val usbInsertDevice: String
        get() = super.usbInsertDevice

    override val usbVersionInfo: String
        get() = super.usbVersionInfo

    override fun insertUsb(): String {
        return "version is $usbVersionInfo,device is $usbInsertDevice"
    }
}

fun main() {
    val usb: IUsb2 = MouseUsb()
    println(usb.insertUsb())
}