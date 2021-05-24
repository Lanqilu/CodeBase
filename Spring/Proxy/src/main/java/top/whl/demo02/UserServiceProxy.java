package top.whl.demo02;

/**
 * @Date: 2020年06月13日  21:04
 * @Description:
 **/
public class UserServiceProxy implements UserService{

    private UserServiceImpl userService;

    public UserServiceProxy() {
    }

    public UserServiceProxy(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void add() {
        log();
        userService.add();
    }

    public void delete() {
        log();
        userService.delete();
    }

    public void update() {
        log();
        userService.update();
    }

    public void query() {
        log();
        userService.query();
    }

    public void log(){
        System.out.println("日志信息");
    }
}
