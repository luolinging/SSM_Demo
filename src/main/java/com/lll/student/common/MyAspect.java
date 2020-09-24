package com.lll.student.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 解决StudentController类中代码冗余的环绕通知类
 * @author luo
 *
 * Aspect 表示当前类是一个切面
 * Component 将MyClass这个类加入到IOC容器中
 */

@Component
@Aspect
@Slf4j
public class MyAspect {

    @Pointcut("execution(* com.lll.student.controller.*.*(..))")
    public void ptAspect(){}

    @Around("ptAspect()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        Object returnValue = null;
        try {
            // 得到方法执行时所需的参数
            Object[] args = proceedingJoinPoint.getArgs();
            // 得到当前方法
            Method methodName = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
            // 明确调用业务层方法（切入点方法）
            returnValue = proceedingJoinPoint.proceed(args);
        } catch (MyException e){
            log.warn("业务异常:{}", e);
            return Result.wrapErrorResult(e.getCode(),e.getMessage());
        } catch (Exception e){
            log.error("非业务异常:{}", e);
            return Result.wrapErrorResult("-1","系统内部错误");
        } catch (Throwable throwable) {
            log.error("非业务异常:{}", throwable);
            return Result.wrapErrorResult("-1","系统内部错误");
        }
        return returnValue;
    }
}
