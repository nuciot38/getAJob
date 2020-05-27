package com.test;

public class Demo extends ADemo implements Inter{

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.show();

        ADemo aDemo = new Demo();
        aDemo.show();

        Inter inter = new Inter() {
            @Override
            public void show() {
                System.out.println("Inter in Demo");
            }
        };
        inter.show();
    }

}
