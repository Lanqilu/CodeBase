package top.whl.service;

import top.whl.dao.UserDao;
import top.whl.dao.UserDaoImpl;
import top.whl.dao.UserDaoMysqlImpl;

/**
 * @Date: 2020年06月09日  18:42
 * @Description:
 **/
public class UserServiceImpl implements UserService{

//    private UserDao userDao = new UserDaoMysqlImpl();

    private UserDao userDao;

    //使用Set进行动态实现值的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
