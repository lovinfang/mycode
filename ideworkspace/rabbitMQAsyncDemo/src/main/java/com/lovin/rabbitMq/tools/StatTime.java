package com.lovin.rabbitMq.tools;

import com.lovin.rabbitMq.vo.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/10/25
 * 创建时间: 17:31
 */
@Aspect
@Service
public class StatTime {

    private Logger logger = LoggerFactory.getLogger(StatTime.class);
    private User user;

    public StatTime() {
        logger.info("************Aop开启");
    }


    @Pointcut("execution(* com.lovin.rabbitMq.service.impl.*.*Register(..))")
    public void stat(){}

    @Around("stat()&&args(user)")
    public Object statTime(ProceedingJoinPoint proceedingJoinPoint,User user){
        this.user = user;
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed(new Object[]{this.user});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        logger.info("************spend time : "+(System.currentTimeMillis()-start)+"ms");
        return result;

    }

}
