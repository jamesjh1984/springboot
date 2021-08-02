package com.jin.springboot.jedis;

import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class PhoneVerificationCode {


    /**
     * flushdb
     *
     *
     * get "20210802:13900000000:count"
     * get "20210802:13900000000:code"
     *
     *
     * 剩余有效时间
     * ttl "20210802:13900000000:code"
     */


    private static String redisHost = "192.168.133.3";
    private static Integer redisPort = 6379;
    private static Integer codeExpirationSecond = 50;
    private static String DateFormat = "yyyyMMdd";



    public static void main(String[] args) {

        // test
//        String ramdomCode = getRamdomCode();
//        System.out.println(ramdomCode);




        // 1. 输入手机号，返回验证码
//        generateCode("13900000000");

        // 2. verify验证码，若验证码过期，返回NullPointerException
        verifyCode("13900000000","814760");

    }








    public static String getDate() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormat);
        Calendar calendar = Calendar.getInstance();
        String currentDate = simpleDateFormat.format(calendar.getTime());
        System.out.println("getDate() => " + currentDate);
        return currentDate;
    }







    // 1. 生成6位数字验证码
    public static String getRamdomCode() {
        Random random = new Random();
        String code = "";
        for (int i=0;i<6;i++) {
            int rand = random.nextInt(10);
            code += rand;
        }
        System.out.println("getRamdomCode(), code => " + code);
        return code;
    }








    // 2. 每个手机每天只能发送三次，验证码放到Redis中，设置count过期时间
    public static void generateCode(String phone) {

        // 创建Jedis对象
        Jedis jedis = new Jedis(redisHost, redisPort);

        // 拼接key, 手机发送次数
        String countKey = getDate() + ":" + phone + ":count";
        System.out.println("generateCode(), countKey => " + countKey);

        // 验证码key
        String codeKey = getDate() + ":" + phone + ":code";
        System.out.println("generateCode(), codeKey => " + codeKey);


        // 每个手机每天只能发送三次
        String count = jedis.get(countKey);
        System.out.println("generateCode(), count => " + count);

        if (count == null) {
            // 没有发送，则是第一次发送，设为1，有效期一天24*60*60秒
            jedis.setex(countKey,24*60*60,"1");

            // 把验证码存到redis里，过期时间60*2秒
            String vCode = getRamdomCode();
            jedis.setex(codeKey,10,vCode);
            jedis.close();

        } else if (Integer.parseInt(count) <= 2) {
            // 发送次数+1
            jedis.incr(countKey);

            // 把验证码存到redis里，过期时间两分钟60*2
            String vCode = getRamdomCode();
            jedis.setex(codeKey,codeExpirationSecond,vCode);
            jedis.close();

        } else if (Integer.parseInt(count) >= 3) {
            // 发送三次，不能再发送
            System.out.println("Verification Code has sent three times, today it's not able to send again...");
            jedis.close();
        }

    }






    // 3. 验证码的校验
    public static void verifyCode(String phone, String inputCode) {
        // 创建Jedis对象
        Jedis jedis = new Jedis(redisHost, redisPort);

        // 验证码key
        String codeKey = getDate() + ":" + phone + ":code";
        System.out.println("verifyCode(), codeKey => " + codeKey);

        String redisCode = jedis.get(codeKey);
        System.out.println("verifyCode(), redisCode => " + redisCode);

        try {
            if (redisCode.equals(inputCode)) {
                System.out.println("Code Verification Success!");
            } else {
                System.out.println("Code Verification Failed!");
            }
        } catch (NullPointerException e) {
            System.out.println("Phone Verification Code has expired, verifyCode() Exception => " + e);
        } finally {
            jedis.close();
        }

    }

}
