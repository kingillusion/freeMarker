package com.king.modelpdf.vo;

/**
 * 单例模式懒汉式之内部类
 *
 * 1.在内部类被加载和初始化时，才创建INSTANCE实例对象
 * 2.静态内部类不会随着外部类的加载和初始化而初始化，他是单独加载和初始化的
 * 3.因为是在内部类加载和初始化时创建的，因此是线程安全的
 */
public class SingletonInner {
    private SingletonInner(){}

    //静态内部类
    private static class Inner{
        //内部类中创建实例对象 线程安全
        private static final SingletonInner INSTANCE = new SingletonInner();
    }

    //调用该方法 才会加载内部类创建对象
    public static SingletonInner getInstance(){
        return Inner.INSTANCE;
    }
}
