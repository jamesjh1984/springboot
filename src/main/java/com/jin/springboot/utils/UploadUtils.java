package com.jin.springboot.utils;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;

public class UploadUtils {

    // return uuid random file name
    public static String getUUIDName(String fileName) {
        String randomFileName;
        int index = fileName.lastIndexOf(".");
        if(index == -1) {
            randomFileName = UUID.randomUUID().toString().replace("-", "").toUpperCase();
            System.out.println(randomFileName);
            return randomFileName;
        } else {
            randomFileName = UUID.randomUUID().toString().replace("-", "").toUpperCase() + fileName;
            System.out.println(randomFileName);
            return randomFileName;
        }
    }


    // return random directory name, it could have 256 directory
    public static String getDir() {
        Timestamp systimestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("systimestamp: " + systimestamp.toString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // sort by date
        System.out.println("yyyyMMdd: " + sdf.format(systimestamp));

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhh"); // sort by hour
//        System.out.println("yyyyMMddhh: " + sdf.format(systimestamp));

        String dateDir = sdf.format(systimestamp);

        String s = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        String dir = dateDir + "/" + s.charAt(r.nextInt(16)) + "/" + s.charAt(r.nextInt(16));
        System.out.println("Random Directory => " + dir);
        return dir;
    }


    public static void main(String[] args) {
        System.out.println(getDir());
    }

}
