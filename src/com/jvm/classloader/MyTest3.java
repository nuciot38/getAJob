package com.jvm.classloader;

import java.util.UUID;

/**
 * str在编译期间未知，只有在运行时才能知道，所以回对MyParent3进行初始化
 * 当一个常量的值并非编译期间可以确定的，那么它的值就不会被放到调用类的常量池中
 * 这是在程序运行时，会导致主动使用这个常量所在的类，显然会导致这个类被初始化
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3 {
    public static final String str = UUID.randomUUID().toString();
    static {
        System.out.println("MyParent3 static code");
    }
}