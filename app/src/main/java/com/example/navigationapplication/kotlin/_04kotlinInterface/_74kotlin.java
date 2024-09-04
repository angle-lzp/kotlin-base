package com.example.navigationapplication.kotlin._04kotlinInterface;

/**
 * author: Angelo.Luo
 * date : 01/04/2024 3:55 PM
 * description:
 */
public class _74kotlin {
}

//懒汉式单例
class LazySingleton {
    private volatile static LazySingleton instance = null;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

}

//饿汉式单例
class EagerSingleton {
    private EagerSingleton() {

    }

    private final static EagerSingleton instance = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return instance;
    }
}