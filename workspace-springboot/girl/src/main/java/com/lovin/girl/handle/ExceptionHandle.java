package com.lovin.girl.handle;

import com.lovin.girl.domain.Result;
import com.lovin.girl.exception.GirlException;
import com.lovin.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            logger.error("转换异常");
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(-1,"未知错误");
        }
    }

}
