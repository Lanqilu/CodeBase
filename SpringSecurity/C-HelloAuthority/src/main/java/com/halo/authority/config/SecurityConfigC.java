package com.halo.authority.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Halo
 * @date Created in 2021/04/15 4:39 PM
 * @description
 */
@Configuration
public class SecurityConfigC extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 退出
        http.logout().logoutUrl("/logout")
                // 退出后跳转地址
                .logoutSuccessUrl("/test/hello").permitAll();

        // 配置没有权限访问跳转自定义页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");

        http.formLogin()
                // 登录页面设置
                .loginPage("/login.html")
                // 登录访问的路径
                .loginProcessingUrl("/user/login")
                // 登录成功之后跳转路径
                .defaultSuccessUrl("/test/index").permitAll()
                .and().authorizeRequests()
                // 设置哪些路径可以不用登录直接访问
                .antMatchers("/", "/test/hello", "/user/login").permitAll()

                // 1. 当前登录用户只有admins权限才可以访问这个路径
                // .antMatchers("/test/index").hasAnyAuthority("admins")

                // 2. 多权限
                // .antMatchers("/text/index").hasAnyAuthority("admins,manager")

                // 3. hasRole 方法
                .antMatchers("/text/index").hasRole("sale")

                .anyRequest().authenticated()
                .and().csrf().disable() // 关闭csrf防护
        ;
    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }
}
