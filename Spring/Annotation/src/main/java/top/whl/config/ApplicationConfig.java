package top.whl.config;

import org.springframework.context.annotation.ComponentScan;
import top.whl.pojo2.Role;
import top.whl.service2.RoleService;

/**
 * @author Halo
 * @date Created in 2020/07/31  16:13
 * @description @ComponentScan
 */
@ComponentScan(basePackageClasses = {Role.class, RoleService.class})
public class ApplicationConfig {
}
