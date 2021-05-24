package com.halo.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author Halo
 * @date Created in 2020/11/04  20:03
 * @description 使用注解方式实现AOP
 */
@Aspect
public class AnnotationAOP {
    @Before("execution(* com.halo.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("[Before]:方法执行前");
    }

    @After("execution(* com.halo.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("[After] :方法执行后");
    }


    /**
     * 在环绕增强中我们可以给定一个参数，代表我们要获取处理切入的点
     */
    @Around("execution(* com.halo.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[Around]:环绕前");
        // 执行方法
        Object proceed = joinPoint.proceed();
        System.out.println("[Around]:环绕后");

        // 获得签名
        Signature signature = joinPoint.getSignature();
        System.out.println("[signature]:" + signature);

    }

}
