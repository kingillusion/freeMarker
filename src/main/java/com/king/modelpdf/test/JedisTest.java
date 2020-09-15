package com.king.modelpdf.test;

import com.king.modelpdf.service.RedisService;
import com.king.modelpdf.service.impl.RedisServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

public class JedisTest extends Thread{
    private String id;
    private String num;
    public JedisTest(String id,String num){
        this.id = id;
        this.num = num;
    }
    public JedisTest(){

    }
    @Override
    public void run() {
        while(true){
            try {
                RedisServiceImpl redisSer = new RedisServiceImpl();
                redisSer.redisService(id,num);
                Thread.sleep(100L);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JedisTest jedisTest = new JedisTest("普通用户","10");
        JedisTest jedisTest2 = new JedisTest("黄金VIP","30");
        jedisTest.start();
        jedisTest2.start();
    }
}
