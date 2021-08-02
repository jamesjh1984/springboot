package com.jin.springboot.jedis;

import redis.clients.jedis.Jedis;

public class JedisDemo {

    public static void main(String[] args) {
        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.44.168",6379); // need to reference VM

        //测试连接Redis能否成功，需要关闭虚拟机上的防火墙
        String value = jedis.ping();
        System.out.println(value); // should return "pong"
    }

}
