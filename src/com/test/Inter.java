package com.test;

public interface Inter {
    public default void show(){
        System.out.println("Inter");
    }

    default void test(){
        System.out.println("test");
    }

}
