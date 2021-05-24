package com.halo.autologin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author Halo
 * @date Created in 2021/04/15 4:39 PM
 * @description
 */
@Configuration
public class SecurityConfigE extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    // 注入数据源
    @Autowired
    private DataSource dataSource;

    // 操作数据库对象
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        // 自动创建表
        // jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                // 登录页面设置
                .loginPage("/login.html")
                // 登录成功之后跳转路径
                .defaultSuccessUrl("/test/index").permitAll()
                .and().authorizeRequests()
                // 设置哪些路径可以不用登录直接访问
                .antMatchers("/", "/test/hello", "/user/login").permitAll()
                // 当前登录用户只有admins权限才可以访问这个路径
                .antMatchers("/test/index").hasAuthority("admins")
                .anyRequest().authenticated()
                // 1. 开启记住我
                .and().rememberMe().tokenRepository(persistentTokenRepository())
                // 2. 设置有效时时长 单位秒
                .tokenValiditySeconds(60)
                // 3. 设置查询数据库的Service
                .userDetailsService(userDetailsService)
                .and().csrf().disable() // 关闭csrf防护
        ;
    }


    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }
}
