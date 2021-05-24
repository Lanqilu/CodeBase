package top.whl.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Date: 2020年06月12日  11:13
 * @Description:
 **/

//等价于bean中<bean id="user" class="top.whl.pojo.User"/>
@Component
@Scope("singleton")
public class User {

    //    @Value("WHL")
    public String name;

    @Value("WHL1")
    public void setName(String name) {
        this.name = name;
    }
}
