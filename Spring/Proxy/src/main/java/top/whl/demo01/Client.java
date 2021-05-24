package top.whl.demo01;

/**
 * @Date: 2020年06月13日  20:46
 * @Description:
 **/
public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}
