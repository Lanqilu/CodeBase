package top.whl.service2.impl;

import org.springframework.stereotype.Component;
import top.whl.pojo2.Role;
import top.whl.service2.RoleService;

/**
 * @author Halo
 * @date Created in 2020/07/31  16:09
 * @description 实现类
 */
@Component
public class RoleServiceImpl implements RoleService {
    public void printRoleInfo(Role role) {
        System.out.println("id = " + role.getId());
        System.out.println("name = " + role.getRoleName());
        System.out.println("note = " + role.getNote());
    }
}
