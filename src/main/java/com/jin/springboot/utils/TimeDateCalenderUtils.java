package com.jin.springboot.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeDateCalenderUtils {


    public static void main(String[] args) {

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");




        /**
         * java.util.Date
         */
        Date date01 = new Date();
        System.out.println("Date() => " + simpleDateFormat.format(date01));




        /**
         * System.currentTimeMillis()
         * 此方法不受时区影响，得到的结果是时间戳格式的。
         * 此方法会根据我们的系统时间返回当前值，因为世界各地的时区是不一样的。
         */
        Date date02 = new Date(System.currentTimeMillis());
        System.out.println("System.currentTimeMillis() => " + simpleDateFormat.format(date02));





        /**
         * Calendar
         * 专门用于转换特定时刻和日历字段之间的日期和时间。
         */
        Calendar calendar = Calendar.getInstance();
        System.out.println("Calendar.getInstance() => " + simpleDateFormat.format(calendar.getTime()));
    }
}
