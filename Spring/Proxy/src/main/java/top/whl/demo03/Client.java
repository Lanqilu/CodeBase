package top.whl.demo03;

/**
 * @Date: 2020年06月13日  20:46
 * @Description:
 **/
public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();
        //代理角色（不存在）
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        //通过调用程序处理角色
        proxyInvocationHandler.setRent(host);
        Rent proxy = (Rent) proxyInvocationHandler.getProxy();// 动态生成
        proxy.rent();
    }
}
