import top.whl.dao.UserDaoImpl;
import top.whl.dao.UserDaoMysqlImpl;
import top.whl.service.UserServiceImpl;

/**
 * @Date: 2020年06月09日  18:44
 * @Description:
 **/
public class TestIoc {
    public static void main(String[] args) {
        //用户调用服务层
        UserServiceImpl userService = new UserServiceImpl();

        //用户选择实现
        userService.setUserDao(new UserDaoImpl());
        userService.getUser();
    }
}
