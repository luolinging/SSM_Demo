package com.lll.student.common;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author luo
 */
@Component
@Aspect
@Slf4j
public class PrintLogAspect {

    @Pointcut("@annotation(com.lll.student.annotation.PrintLogAnnotation)")
    public void printLog(){}

    @Around("printLog()")
    public Object aroundPrintLog(ProceedingJoinPoint point) throws Throwable{
        // 当前方法名 ,通过反射的方式 Method类 去获取
        Method methodName = ((MethodSignature) point.getSignature()).getMethod();
        log.info("方法名：{}",methodName);
        // 方法所需的参数
        Object[] args = point.getArgs();
        log.info("方法的参数：{}",args);
        long startTime = System.currentTimeMillis();
        // 调用业务方法
        Object returnValue = point.proceed(args);
        long endTime = System.currentTimeMillis();
        log.info("执行时间：{} ms", endTime - startTime);
        log.info("方法的返回值：{}", JSON.toJSONString(returnValue));
        return returnValue;
    }
}
