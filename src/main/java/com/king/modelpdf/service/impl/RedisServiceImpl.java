package com.king.modelpdf.service.impl;

import com.king.modelpdf.service.RedisService;
import com.king.modelpdf.utils.JedisUtils;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class RedisServiceImpl implements RedisService {
    public static final String LOCALHOST = "127.0.0.1";
    public static final Integer PORT = 6379;
    public static final String SUPER_VIP = "SVIP";
    public static final String GOLD_VIP = "GVIP";
    public static final String COMMON_VIP = "CUSER";
    public static final String SVIP_NUM = "50";
    public static final String GVIP_NUM = "30";
    public static final String COMMON_NUM = "10";
    public static final String USER = "user";


    private String id;
    @Override
    public void redisService(String id,String number) {
        Integer num = Integer.parseInt(number);
        Jedis jedis = JedisUtils.getJedis();
        String value = jedis.get("user:"+id);

        jedis.hset(USER,SUPER_VIP,SVIP_NUM);
        jedis.hset(USER,GOLD_VIP,GVIP_NUM);
        jedis.hset(USER,COMMON_VIP,COMMON_NUM);

        final Map<String, String> stringMap = jedis.hgetAll(USER);

        try{
            Iterator<Map.Entry<String, String>> itd = stringMap.entrySet().iterator();
            Map.Entry<String, String> en;
            while (itd.hasNext()){
                en = itd.next();
                en.getKey();
                en.getValue();

            }
            if(null==value){
                jedis.setex("user:"+id,10,Long.MAX_VALUE-num+"");
            }else{
                Long val = jedis.incr("user:"+id);
                System.out.println("user:"+id+"---操作中。。。已使用"+(num-(Long.MAX_VALUE-val))+"次");
            }
        }catch (JedisDataException e){
            System.out.println(id+"超过使用上限次数！");
            return;
        }finally {
            jedis.close();
        }
    }
}
