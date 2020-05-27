package com.test;

public class Ttest {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }

    static class SupClass{
        public static int value = 10;
        static {
            System.out.println("SupClass init");
        }
    }
    static class SubClass extends SupClass{
        static {
            System.out.println("SubClass init");
        }
    }
}
