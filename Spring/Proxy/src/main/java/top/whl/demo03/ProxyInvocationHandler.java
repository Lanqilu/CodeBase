package top.whl.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Date: 2020年06月13日  21:16
 * @Description:
 **/
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成得到代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    //处理代理实例，并返回结果
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        //反射实现
        Object result = method.invoke(rent, args);
        fee();
        sign();
        return result;
    }

    public void fee() {
        System.out.println("收小费");
    }

    public void sign() {
        System.out.println("签合同");
    }

}
