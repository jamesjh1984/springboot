package com.jin.springboot.jedis;

import redis.clients.jedis.Jedis;

public class JedisDemo {

    /**
     * 修改配置文件(/etc/redis.conf)，允许远程访问，重启：
     *      # bind 127.0.0.1 -::1
     *      protected-mode no
     *
     *
     * -----------------------------
     *
     *
     * 开启命令：
     *      cd /usr/local/bin
     *      redis-server /etc/redis.conf
     *      redis-cli
     */
    public static void main(String[] args) {

        String redisHost = "192.168.133.3";
        Integer redisPort = 6379;

        //创建Jedis对象
        Jedis jedis = new Jedis(redisHost, redisPort);

        //测试连接Redis能否成功，若报错，还需关闭Linux上的防火墙
        String value = jedis.ping();
        System.out.println(value); // should return "PONG"

        jedis.close();
    }

}
