package com.halo.custom;

/**
 * @author Halo
 * @date Created in 2020/11/04  17:09
 * @description 自定义切入点类
 */
public class CustomPointCut {
    public void before() {
        System.out.println("======方法执行前======");
    }
    public void after() {
        System.out.println("======方法执行后======");
    }
}
