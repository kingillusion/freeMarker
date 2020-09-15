package com.king.modelpdf.vo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 饿汉式单例模式
 * 静态代码块饿汉式
 *
 */
public class SingletonStatic {
    private static final SingletonStatic INCETANCE;
    private String info;

    //使用场景：属性需要初始化
    static {
        InputStreamReader inputStreamReader = null;
        try{
            //配置文件工具类
            Properties pro = new Properties();
            //src文件夹才能使用类加载器
            //pro.load(Singleton.class.getClassLoader().getResourceAsStream("properties.properties"));
            inputStreamReader = new InputStreamReader(SingletonStatic.class.getClassLoader().getResourceAsStream("properties.yml"),"UTF-8");
            pro.load(inputStreamReader);
            INCETANCE = new SingletonStatic(pro.getProperty("mes"));
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

    public SingletonStatic(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return  info;
    }

    public static void main(String[] args) {
        SingletonStatic s = SingletonStatic.INCETANCE;
        System.out.println(s);
    }
}
