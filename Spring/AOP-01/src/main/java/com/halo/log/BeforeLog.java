package com.halo.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author Halo
 * @date Created in 2020/11/04  16:28
 * @description 前置通知
 */
public class BeforeLog implements MethodBeforeAdvice {
    @Override
    /**
     *
     *
     * @param method: 要执行的目标对象的方法
     * @param args: 参数
     * @param target:  目标对象
     * @return void
     */
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("日志:" + target.getClass().getName() + " 的 " + method.getName() + " 被执行了");
    }
}
