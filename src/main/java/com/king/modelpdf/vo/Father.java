package com.king.modelpdf.vo;

/**
 * 初始化父类<clinit>()方法包括静态类变量显示赋值代码和静态代码块组成，执行顺序自上而下；
 *
 *父类实例化:
 * super();(最先)
 * 非静态实例变量显示赋值代码（谁在前先执行谁）
 * 非静态代码块 （谁在前先执行谁）
 * 构造器（最后）
 */
public class Father {

    private int i = test();

    private static int j = method();

    static {
        System.out.print("[1]");
    }
    Father(){
        System.out.print("[2]");
    }
    {
        System.out.print("[3]");
    }
    public int test(){
        System.out.print("[4]");
        return 1;
    }
    public static int method(){
        System.out.print("[5]");
        return 1;
    }


}
