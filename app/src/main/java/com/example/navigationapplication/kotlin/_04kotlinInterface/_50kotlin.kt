package com.example.navigationapplication.kotlin._04kotlinInterface

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */
//todo 接口
//1.接口里面的成员和接口本身都是public open 的，所以不需要open，这个是kotlin中接口的特殊
//2.接口不能有构造函数
//3.实现类不仅仅要重写接口的函数，也要重写接口的成员(变量)
//4.接口实现代码区域，全部需要加上 override 关键字来修饰

//接口
interface IUsb {
    var usbVersionInfo: String
    var usbInsertDevice: String

    fun insertUsb(): String
}

//实现类(实现方式一：变量放在构造器中)
class Mouse(
    override var usbVersionInfo: String = "USB 3.0",
    override var usbInsertDevice: String = "鼠标接入接口"
) : IUsb {
    override fun insertUsb(): String {
        return "versionInfo is $usbVersionInfo,device is $usbInsertDevice"
    }
}

//实现类（方式二：变量放在class里面）
class KeyBoard : IUsb {
    override var usbVersionInfo: String
        get() = "USB 3.0"
        set(value) {
            this.usbVersionInfo = value
        }
    override var usbInsertDevice: String
        get() = "键盘接口"
        set(value) {
            this.usbInsertDevice = value
        }

    override fun insertUsb(): String {
        return "versionInfo is $usbVersionInfo，device is $usbInsertDevice"
    }
}

fun main() {
    val mouseUsb : IUsb = Mouse()
    println(mouseUsb.insertUsb())


    val keyBoardUsb : IUsb = KeyBoard()
    println(keyBoardUsb.insertUsb())
}
