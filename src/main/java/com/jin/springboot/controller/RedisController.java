package com.jin.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



// http://localhost:8080/redis
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public String testRedis() {
        // 设置key-value到Redis
        redisTemplate.opsForValue().set("name","Lebron James");

        // 从Redis里取值
        String name = (String)redisTemplate.opsForValue().get("name");

        return name;
    }
}
