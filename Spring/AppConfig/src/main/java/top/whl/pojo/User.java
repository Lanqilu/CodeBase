package top.whl.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Date: 2020年06月12日  11:51
 * @Description:
 **/
@Component
public class User {
    private String name;

    public String getName() {
        return name;
    }

    @Value("WHL")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

