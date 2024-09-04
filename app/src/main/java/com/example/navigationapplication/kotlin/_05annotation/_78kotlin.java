package com.example.navigationapplication.kotlin._05annotation;

/**
 * author: Angelo.Luo
 * date : 01/04/2024 4:44 PM
 * description:
 */
public class _78kotlin {

    public static void main(String[] args) {
        //字段和方法上没有加注解需要这样调用在Java中
        System.out.println(Other.Companion.getInfo());
        Other.Companion.show();

        //加了注解后
        System.out.println(Other.name);
        Other.print();
    }
}
