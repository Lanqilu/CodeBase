package top.whl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import top.whl.pojo.User;

/**
 * @Date: 2020年06月12日  11:53
 * @Description:
 **/
@Configuration
@ComponentScan("top.whl")
public class Config01 {
    @Bean
    public User getUser(){
        return new User();
    }
}
