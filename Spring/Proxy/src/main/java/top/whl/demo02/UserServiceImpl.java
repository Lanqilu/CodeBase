package top.whl.demo02;

/**
 * @Date: 2020年06月13日  21:02
 * @Description:
 **/
public class UserServiceImpl implements UserService{

    public void add() {
        System.out.println("增加一个用户");
    }

    public void delete() {
        System.out.println("删除一个用户");
    }

    public void update() {
        System.out.println("更新用户信息");
    }

    public void query() {
        System.out.println("查找用户信息");
    }
}
