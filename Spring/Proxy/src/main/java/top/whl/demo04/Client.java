package top.whl.demo04;

import top.whl.demo02.UserService;
import top.whl.demo02.UserServiceImpl;;

/**
 * @Date: 2020年06月13日  21:34
 * @Description:
 **/
public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();
        //代理角色（不存在）
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();

        //设置代理对象
        proxyInvocationHandler.setTarget(userService);
        //动态生成代理类
        UserService proxy = (UserService) proxyInvocationHandler.getProxy();

        proxy.delete();
        proxy.add();
        proxy.update();
        proxy.query();

    }
}
