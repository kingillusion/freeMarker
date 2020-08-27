package com.king.modelpdf.vo;

/**
 * 饿汉式单例模式
 * 直接实例化饿汉式
 */
public class SingletonDirect {
    private SingletonDirect(){}
    public static final SingletonDirect INSTANCE = new SingletonDirect();

    @Override
    public String toString() {
        return "SingletonDirect{}";
    }

    public static void main(String[] args) {
        SingletonDirect s = new SingletonDirect();
        System.out.println(s);
    }
}
