package com.example.navigationapplication.kotlin._05annotation;

/**
 * author: Angelo.Luo
 * date : 01/04/2024 4:27 PM
 * description:
 */
public class _76kotlin {

    public static void main(String[] args) {
        System.out.println(new Person().names);//使用了@JvmField注解
        System.out.println(new Person().getDatas());//没有
    }
}
