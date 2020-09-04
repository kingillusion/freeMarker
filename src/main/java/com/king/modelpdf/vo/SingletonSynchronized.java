package com.king.modelpdf.vo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 单例模式懒汉式之线程不安全
 */
public class SingletonSynchronized {
    //私有构造器
    private SingletonSynchronized(){}
    //私有静态实例
    private static SingletonSynchronized instance;
    //提供静态方法获取实例对象
    //线程安全（适合多线程）
    public static SingletonSynchronized getInstance(){
        if(instance == null){//该判断是为了性能考虑
            synchronized (SingletonSynchronized.class){
                if(instance == null){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new SingletonSynchronized();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws Exception{
        //匿名内部类写法
        /*Callable<SingletonUnSafe> callable = new Callable<SingletonUnSafe>() {
            @Override
            public SingletonUnSafe call() throws Exception {
                //获取对象
                return SingletonUnSafe.getInstance();
            }
        };*/
        //Lamda表达式写法
        //线程体 目的为了获取实例对象
        Callable<SingletonSynchronized> calls = ()->{return SingletonSynchronized.getInstance();};

        //启动线程池 创建两个线程
        ExecutorService service = Executors.newFixedThreadPool(2);

        //提交线程 返回Future对象
        Future<SingletonSynchronized> f1 = service.submit(calls);
        Future<SingletonSynchronized> f2 = service.submit(calls);


        SingletonSynchronized s1 = f1.get();
        SingletonSynchronized s2 = f2.get();

        System.out.println(s1==s2);
        System.out.println(s1);
        System.out.println(s2);

        //关闭线程池
        service.shutdown();
    }
}
