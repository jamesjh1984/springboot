package com.jin.springboot;

import com.jin.springboot.exception.ParamsException;
import com.jin.springboot.model.ResultInfo;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = ParamsException.class)
//    @ResponseBody
//    public ResultInfo resolverParamsException(ParamsException ex) {
//        ResultInfo resultInfo = new ResultInfo();
//        resultInfo.setCode(ex.getCode());
//        resultInfo.setMsg(ex.getMsg());
//        return resultInfo;
//    }
//
//
//
//    // 处理参数绑定异常
//    @ExceptionHandler(value = BindException.class)
//    @ResponseBody
//    public ResultInfo resolverBindException(BindException ex) {
//        ResultInfo resultInfo = new ResultInfo();
//        resultInfo.setCode(500);
//        resultInfo.setMsg(ex.getBindingResult().getFieldError().getDefaultMessage());
//        return resultInfo;
//    }

}
