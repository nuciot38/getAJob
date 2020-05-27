package com.jvm.classloader;

/**
 * 在编译阶段，这个常量就会被存入到调用这个常量的那个方法所在的类的常量池中
 * 本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化
 * 注意：这里指的是将常量存放到了MyTest2的常量池中，之后MyTest2与MyParent2就没有任何关系了
 * 甚至我们可以将MyParent2的class文件删除
 */

/**
 * 助记符：
 * ldc标识将int, float或是String类型的常量池从常量池中推送至栈顶
 * bipush表示将单字节(-128, 127)的常量值推送至栈顶
 * sipush表示将一个短整型常量值(-32768, 32767)推送至栈顶
 * iconst_1标识将int型的数字1推送至栈顶(iconst_1, iconst_5)
 */

public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.str);
    }
}

class MyParent2 {
    public static final String str = "hello world";

    public static final short s = 7;

    static {
        System.out.println("MyParent2 static block");
    }
}
