package com.jin.springboot.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class TestJedisDemo {

    // 1. 操作Key String
    @Test
    public void demo01() {

        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.44.168",6379); // need to reference VM

        //添加
        jedis.set("key1","Lebron James");

        //获取
        String name = jedis.get("key1");
        System.out.println("jedis.get =>" + name);


        //设置多个key-value
        jedis.mset("k1","v2","k2","v2","k3","v3");
        List<String> mget = jedis.mget("k1","k2","k3");
        System.out.println("jedis.mget =>" + mget);


        //遍历输出
        Set<String> keys = jedis.keys("*");
        for (String i: keys) {
            System.out.println("jedis.keys =>" + i);
        }
    }






    // 2. 操作list
    @Test
    public void demo02() {

        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.44.168",6379); // need to reference VM

        jedis.lpush("key2","James","Jordan","Kobe");
        List<String> values = jedis.lrange("key2",0,-1);

        System.out.println("jedis.lrange =>" + values);
    }



    // 3. set
    @Test
    public void demo03() {

        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.44.168",6379); // need to reference VM

        jedis.sadd("key3","James","Jordan","Kobe");
        Set<String> names = jedis.smembers("key3");

        System.out.println("jedis.smembers =>" + names);
    }
}
