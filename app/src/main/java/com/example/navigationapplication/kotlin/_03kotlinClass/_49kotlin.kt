package com.example.navigationapplication.kotlin._03kotlinClass

/**
 * author: Angelo.Luo
 * date : 01/02/2024 8:53 AM
 * description:
 */

//todo 枚举：数据类使用条件
data class DataClass(var userName: String)

/**
 *1，服务器请求回来的响应的 JavaBean LoginResponseBean 基本上可以使用 数据类
 *2，数据类至少必须要有一个参数的主构造函数
 *3，数据类必须要有参数，var\val的参数
 *4，数据类不能使用 abstract、open、sealed、inner 等等 修饰（数据类主要的作用就是数据的载入和数据存储）
 *5，数据类有：比较、copy、toString、结构等功能，比较丰富
 *
 */