package com.jin.springboot.utils;

import com.jin.springboot.exception.ParamsException;

public class AssertUtils {

    public static void isTure(Boolean flag, String msg) {
        if(flag) {
            throw new ParamsException(msg);
        }
    }
}
