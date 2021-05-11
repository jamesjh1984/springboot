package com.jin.springboot.utils;

import org.junit.Test;

import javax.annotation.Resource;


public class TestUploadUtils {


    @Resource
    private UploadUtils uploadUtils;



    @Test
    public void getUUIDName() {
        uploadUtils.getUUIDName("lakers.txt");
        uploadUtils.getUUIDName("lakers.png");
    }


    @Test
    public void getDir() {
        uploadUtils.getDir();
    }
}