package com.jvm.classloader;

/**
 * 对于数组实力来说，其类型是由JVM在运行期动态生成的，表示为[Lcom.jvm.classloader.MyParent4这种形式。动态生成的类型，其父类型就是Object
 * 对于数组来说，JavaDoc经常将构成数组的元素为Component，实际上就是将数组讲第一个维度后的类型
 * 助记符：
 * anewarray：表示创建一个引用类型的数组(如类，接口，数组)，并将其引用值压入栈顶
 * newarray:表示创建一个指定的原始类型(如int,float,char等)的数组，并将其引用值压入栈顶
 */
public class MyTest4 {
    public static void main(String[] args) {
//        MyParent4 m = new MyParent4();
        MyParent4[] myParent4s = new MyParent4[1];
        System.out.println(myParent4s.getClass().getSuperclass());
    }
}

class MyParent4{
    static {
        System.out.println("MyParent4 static code");
    }
}