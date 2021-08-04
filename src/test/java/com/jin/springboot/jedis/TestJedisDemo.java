package com.jin.springboot.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class TestJedisDemo {

    /**
     * x260(桥接): 192.168.31.201
     * x1(桥接):   192.168.31.200
     */
    String redisHost = "192.168.31.201";
    Integer redisPort = 6379;


    // 1. 操作Key String
    @Test
    public void demo01() {

        //创建Jedis对象
        Jedis jedis = new Jedis(redisHost,redisPort);

        //添加
        jedis.set("key1","Lebron James");

        //获取
        String name = jedis.get("key1");
        System.out.println("jedis.get => " + name);


        //设置多个key-value
        jedis.mset("k1","v1","k2","v2","k3","v3");
        List<String> mget = jedis.mget("k1","k2","k3");
        System.out.println("jedis.mget => " + mget);


        //遍历输出
        Set<String> keys = jedis.keys("*");
        for (String i: keys) {
            System.out.println("jedis.keys => " + i);
        }

        jedis.close();
    }






    // 2. 操作list
    @Test
    public void demo02() {

        //创建Jedis对象
        Jedis jedis = new Jedis(redisHost,redisPort);

        jedis.lpush("key2","James","Jordan","Kobe");
        List<String> values = jedis.lrange("key2",0,-1);

        System.out.println("jedis.lrange => " + values);

        jedis.close();
    }






    // 3. 操作set
    @Test
    public void demo03() {

        //创建Jedis对象
        Jedis jedis = new Jedis(redisHost,redisPort);

        jedis.sadd("key3","James","Jordan","Kobe");
        Set<String> names = jedis.smembers("key3");

        System.out.println("jedis.smembers => " + names);

        jedis.close();
    }






    // 4. 操作hash
    @Test
    public void demo04() {

        //创建Jedis对象
        Jedis jedis = new Jedis(redisHost,redisPort);

        jedis.hset("key4","name","Lebron James");
        jedis.hset("key4","age","36");

        String hgetName = jedis.hget("key4","name");
        String hgetAge = jedis.hget("key4","age");

        System.out.println("jedis.hget => " + hgetName);
        System.out.println("jedis.hget => " + hgetAge);

        jedis.close();
    }






    // 5. 操作zset
    @Test
    public void demo05() {

        //创建Jedis对象
        Jedis jedis = new Jedis(redisHost,redisPort);

        jedis.zadd("key5", 100d, "Lakers");
        jedis.zadd("key5", 95d, "Celtics");
        jedis.zadd("key5", 90d, "Knicks");

        Set<String> zrange = jedis.zrange("key5",0,-1);
        System.out.println("jedis.zrange => " + zrange);

//        for (String i: zrange) {
//            System.out.println("jedis.zrange => " + i);
//        }

        jedis.close();
    }
}
