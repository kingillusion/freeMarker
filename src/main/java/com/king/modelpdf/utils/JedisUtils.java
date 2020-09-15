package com.king.modelpdf.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * Jedis 工具类
 */
public class JedisUtils {
    private static JedisPool jedisPool = null;

    private static String ip;
    private static Integer port;
    private static Integer maxTotal;
    private static Integer maxIdle;
    static {
        ResourceBundle rb = ResourceBundle.getBundle("redis");

        ip = rb.getString("redis.ip");
        port = Integer.parseInt(rb.getString("redis.port"));
        maxTotal = Integer.parseInt(rb.getString("redis.maxTotal"));
        maxIdle = Integer.parseInt(rb.getString("redis.maxIdle"));

        JedisPoolConfig jpc = new JedisPoolConfig();
        jpc.setMaxIdle(maxIdle);
        jpc.setMaxTotal(maxTotal);
        jedisPool = new JedisPool(jpc,ip,port);
    }
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
