package top.whl.demo02;

/**
 * @Date: 2020年06月13日  21:08
 * @Description:
 **/
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);
        proxy.add();
        proxy.delete();
        proxy.update();
        proxy.query();

    }
}
