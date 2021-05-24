package com.halo.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author Halo
 * @date Created in 2020/11/04  16:36
 * @description 后置通知
 */
public class AfterLog implements AfterReturningAdvice {


    /**
     * @param returnValue: 返回值
     * @param method:
     * @param args:
     * @param target:
     * @return void
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("日志:执行了 " + method.getName() + " 方法,返回的结果为: " + returnValue);
    }
}
