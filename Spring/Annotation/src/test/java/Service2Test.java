import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.whl.config.ApplicationConfig;
import top.whl.pojo2.Role;
import top.whl.service2.RoleService;

/**
 * @author Halo
 * @date Created in 2020/07/31  16:15
 * @description @ComponentScan
 */
public class Service2Test {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Role role = context.getBean(Role.class);
        RoleService roleService = context.getBean(RoleService.class);
        roleService.printRoleInfo(role);
        context.close();
    }
}
