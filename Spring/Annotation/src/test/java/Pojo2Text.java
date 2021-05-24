import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.whl.pojo2.PojoConfig;
import top.whl.pojo2.Role;

/**
 * @author Halo
 * @date Created in 2020/07/31  15:42
 * @description @Component装配Bean
 */
public class Pojo2Text {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PojoConfig.class);
        Role role = context.getBean(Role.class);
        System.out.println("role.getId() = " + role.getId());
    }
}
