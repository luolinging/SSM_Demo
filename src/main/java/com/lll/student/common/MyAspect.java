package com.lll.student.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 解决StudentController类中代码冗余的环绕通知类
 * @author luo
 *
 * Aspect 表示当前类是一个切面
 * Component 将MyClass这个类加入到IOC容器中
 */

@Component
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.lll.student.controller.*.*(..))")
    public void ptAspect(){}

    @Around("ptAspect()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        Object returnValue = null;
        try {
            // 得到方法执行时所需的参数
            Object[] args = proceedingJoinPoint.getArgs();
            // 明确调用业务层方法（切入点方法）
            returnValue = proceedingJoinPoint.proceed();
        } catch (MyException e){
            return new Result<>(e.getCode(),false, e.getMessage(),null);
        } catch (Exception e){
            return new Result<>("-1", false, "系统内部错误", null);
        }catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return returnValue;
    }
}
