package com.king.modelpdf.vo;

/**
 * 子类初始化：<clinit>()方法包括静态类变量显示赋值代码和静态代码块组成，执行顺序自上而下；
 *
 *本类初始化：
 * 先初始化父类 [5] [1]
 * 初始化子类  [10] [6]
 *
 *本类实例化：
 * 先实例化父类
 * 实例化子类
 *
 *
 *子类实例化:
 * super();(最先)
 * 非静态实例变量显示赋值代码（谁在前先执行谁）
 * 非静态代码块 （谁在前先执行谁）
 * 构造器（最后）
 */
public class Son extends Father {

    private int i = test();

    private static int j = method();

    static {
        System.out.print("[6]");
    }
    Son(){
        System.out.print("[7]");
    }
    {
        System.out.print("[8]");
    }
    public int test(){
        System.out.print("[9]");
        return 1;
    }
    public static int method(){
        System.out.print("[10]");
        return 1;
    }
    public static void main(String[] args) {

    }
}
