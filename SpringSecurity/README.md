## 模块说明

### HelloSecurity

#### SpringSecurity入门使用

首先引入相关依赖

```xml

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
</dependencies>
```

编写 controller

```java

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("hello")
    public String hello() {
        return "Hello Halo";
    }
}
```

启动主程序,访问接口地址,就可以看到 SpringSecurity 的登录界面。

其中用户名默认为 user ,密码在控制台日志中输出。

#### 使用配置文件自定义用户名和密码

在配置文件中加上如下配置

```yml
spring:
  security:
    user:
      # 设置登录系统的账号、密码
      name: halo
      password: halo
```

#### 使用配置类自定义用户和密码

将上述配置文件内容注释，创建配置类

```java

@Configuration
public class SecurityConfigA extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 密码加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
                .withUser("username").password(password).roles("admin");
    }
}
```

或者使用如下方式

```java

@Configuration
public class SecurityConfigA extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 密码加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        auth.inMemoryAuthentication().withUser("username").password(password).roles("admin");
    }

    // 通过创建Bean实现，或者使用链式编程引入
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

#### 自定义实现类(常用)

1. 创建配置类，设置使用 `userDetailsService` 的实现类
2. 编写实现类，返回User对象，User对象有用户名密码和操作权限

```java

@Configuration
public class SecurityConfigB extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }
}
```

```java

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
        return new User("username", new BCryptPasswordEncoder().encode("password"), authorities);
    }
}
```

### SecurityByDatabase

#### 数据库认证来完成用户登录

导入依赖

```xml

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <!--mybatis-plus-->
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>3.0.5</version>
    </dependency>
    <!--mysql-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
    <!--lombok 用来简化实体类-->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
</dependencies>
```

创建数据库及数据表

```sql
create table users
(
    id       int not null,
    username varchar(10) null,
    password varchar(10) null
);
```

创建数据表对应实体类

```java

@Data
public class Users {
    private Integer id;
    private String username;
    private String password;
}
```

整合 Mybatis-Plus,创建 Mapper 继承 BaseMapper

```java
public interface UsersMapper extends BaseMapper<Users> {

}
```

在 Service 中调用 Mapper 中的方法查询数据库

```java

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 调用usersMapper方法，根据用户名查询数据库
        QueryWrapper<Users> wrapper = new QueryWrapper();
        // where username=?
        wrapper.eq("username", username);
        Users users = usersMapper.selectOne(wrapper);
        // 判断,数据库是否存在用户名，认证失败
        if (users == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        List<GrantedAuthority> auths =
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_sale");
        // 从查询数据库返回users对象，得到用户名和密码，返回
        return new User(users.getUsername(),
                new BCryptPasswordEncoder().encode(users.getPassword()), auths);
    }
}
```

在启动类上添加`@MapperScan`

```java

@SpringBootApplication
@MapperScan("com.halo.authority.mapper")
public class DatabaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }
}

```

配置配置文件

```yml

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://mysql:3306/spring_security?serverTimezone=GMT%2B8
    username: root
    password: root
```

其中config和controller同上配置

#### 自定义用户页面

配置类中实现相关配置

```java

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
        http.formLogin()
                .loginPage("/login.html") // 登录页面设置
                .loginProcessingUrl("/user/login")   // 登录访问的路径
                .defaultSuccessUrl("/test/index").permitAll() // 登录成功之后跳转路径
                .and().authorizeRequests()
                .antMatchers("/", "/test/hello", "/user/login").permitAll() // 设置哪些路径可以不用登录直接访问
                .anyRequest().authenticated()
                .and().csrf().disable() // 关闭csrf防护
        ;
    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }
}

```

创建静态页面,其中name需要对应username和password，不能改变

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="/user/login" method="post">
    用户名：<input type="text" name="username"/><br/>
    密 码：<input type="text" name="password"/><br/>
    <input type="submit" value="login">
</form>

</body>
</html>
```

controller中加入index测试接口

```java

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("hello")
    public String hello() {
        return "Hello Halo";
    }

    @GetMapping("index")
    public String index() {
        return "Index";
    }

}

```

### HelloAuthority

基于角色或权限的访问控制

#### hasAuthority

如果当前主体具有指定权限，则返回 true,否则返回 false

只能针对单一权限，多权限不适用

在配置类中设置当前访问地址有哪个权限

```java

@Configuration
public class SecurityConfigC extends WebSecurityConfigurerAdapter {
    //...
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/test/index").permitAll()
                .and().authorizeRequests()
                .antMatchers("/", "/test/hello", "/user/login").permitAll()
                // 当前登录用户只有admins权限才可以访问这个路径
                .antMatchers("/test/index").hasAnyAuthority("admins")
                .anyRequest().authenticated()
                .and().csrf().disable() // 关闭csrf防护
        ;
    }
}

```

在 UserDetailsService,设置返回对象User的权限

```java

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 调用usersMapper方法，根据用户名查询数据库
        QueryWrapper<Users> wrapper = new QueryWrapper();
        // where username=?
        wrapper.eq("username", username);
        Users users = usersMapper.selectOne(wrapper);
        // 判断,数据库是否存在用户名，认证失败
        if (users == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        List<GrantedAuthority> auths =
                AuthorityUtils.commaSeparatedStringToAuthorityList("admins");
        // 从查询数据库返回users对象，得到用户名和密码，返回
        return new User(users.getUsername(),
                new BCryptPasswordEncoder().encode(users.getPassword()), auths);
    }
}

```

#### hasAnyAuthority 方法

在配置类中设置当前访问地址有哪些权限

```java

@Configuration
public class SecurityConfigC extends WebSecurityConfigurerAdapter {
    //...
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/test/index").permitAll()
                .and().authorizeRequests()
                .antMatchers("/", "/test/hello", "/user/login").permitAll()
                // 2. 多权限
                .antMatchers("/text/index").hasAnyAuthority("admins,manager")
                .anyRequest().authenticated()
                .and().csrf().disable() // 关闭csrf防护
        ;
    }
}

```

#### hasRole 和 hasAnyRole 方法

存疑，无论怎么改，都可以访问达不到限制的作用

如果用户具备给定角色就允许访问，否则拒绝

```java

@Configuration
public class SecurityConfigC extends WebSecurityConfigurerAdapter {
    // ...
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/test/index").permitAll()
                .and().authorizeRequests()
                .antMatchers("/", "/test/hello", "/user/login").permitAll()
                // 3. hasRole 方法
                .antMatchers("/text/index").hasRole("sale")
                .anyRequest().authenticated()
                .and().csrf().disable() // 关闭csrf防护
        ;
    }
}

```

在 UserDetailsService 中加入角色，注意角色前要加 `ROLE_` 前缀

同 hasAnyAuthority 方法，hasAnyRole 方法使用类似

#### 自定义403页面

添加页面

修改config下的配置类

```java

@Configuration
public class SecurityConfigC extends WebSecurityConfigurerAdapter {

    //...

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置没有权限访问跳转自定义页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");

        http.formLogin()
        //...
        ;
    }
}

```

#### 用户注销

在配置类中添加有关配置

```java

@Configuration
public class SecurityConfigC extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 退出
        http.logout().logoutUrl("/logout")
                // 退出后跳转地址
                .logoutSuccessUrl("/test/hello").permitAll();
        //...
    }

    //...
}
```

修改 controller 进行测试

```java

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("hello")
    public String hello() {
        return "Hello Halo";
    }

    @GetMapping("index")
    public String index() {
        return "Index <a href='/logout'>退出</a>";
    }

}
```

### Annotation

有关注解的使用

#### @Secured

用户具有某个角色，可以访问方法

注意：使用前需要在启动类(配置类)中开启注解的使用

```java

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
@MapperScan("com.halo.annotation.mapper")
public class AnnotationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnnotationApplication.class, args);
    }
}

```

判断是否具有角色，另外需要注意的是这里匹配的字符串需要添加前缀 `ROLE_`

在 Controller 方法中增加相关接口

```java

@RestController
@RequestMapping("/test")
public class TestController {
    // ...
    @GetMapping("secured")
    @Secured({"ROLE_sale", "ROLE_manager"})
    public String secured() {
        return "Hello Secured";
    }
}

```

在 UserDetailsService 中设置用户角色

#### @PreAuthorize

进入方法前的权限验证

在启动类(配置类)中开启注解

```java

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@MapperScan("com.halo.annotation.mapper")
public class AnnotationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnnotationApplication.class, args);
    }
}
```

在 Controller 方法中增加相关接口

```java

@RestController
@RequestMapping("/test")
public class TestController {
    //...
    @GetMapping("PreAuthorize")
    @PreAuthorize("hasAnyAuthority('admins')")
    public String preAuthorize() {
        return "Hello PreAuthorize";
    }
}

```

在 UserDetailsService 中设置用户权限

#### @PostAuthorize

在方法执行之后再进行权限验证，适合验证带有返回之的权限

在启动类(配置类)中开启注解

```java

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@MapperScan("com.halo.annotation.mapper")
public class AnnotationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnnotationApplication.class, args);
    }
}
```

在 Controller 方法中增加相关接口

```java

@RestController
@RequestMapping("/test")
public class TestController {
    //...
    @GetMapping("PostAuthorize")
    @PostAuthorize("hasAnyAuthority('other')")
    public String postAuthorize() {
        System.out.println("进入了PostAuthorize");
        return "Hello PostAuthorize";
    }
}

```

在 UserDetailsService 中设置用户权限

在没有权限的情况下，进入地址可以看到403页面，但是在控制台中有输出，证明执行了方法。

#### @PostFilter

权限验证之后对数据进行过滤

例如，留下用户名是admin的数据

```java

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("PostFilter")
    @PreAuthorize("hasAnyAuthority('admins')")
    @PostFilter("filterObject.username=='admin'")
    public List<Users> postFilter() {
        ArrayList<Users> users = new ArrayList<>();
        users.add(new Users(1, "Halo", "Halo"));
        users.add(new Users(2, "admin", "admin"));
        return users;
    }
}
```

#### @PreFilter

进入控制器前对数据进行过滤

```java

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("PreFilter")
    @PreAuthorize("hasAnyAuthority('admins')")
    @PreFilter(value = "filterObject.id%2==0")
    public List<Users> preFilter(@RequestBody List<Users> list) {
        list.forEach(t -> System.out.println(t.getId() + "\t" + t.getUsername()));
        return list;
    }
}
```

使用PostMan进行测试，登录后加入Cookie数据

![](https://img.imgdb.cn/item/607970cc8322e6675c57a6da.png)

加入测试数据

![](https://img.imgdb.cn/item/607970b48322e6675c577741.png)

```json
[
  {
    "id": "1",
    "username": "admin",
    "password": "666"
  },
  {
    "id": "2",
    "username": "admins",
    "password": "888"
  },
  {
    "id": "3",
    "username": "admins11",
    "password": "11888"
  },
  {
    "id": "4",
    "username": "admins22",
    "password": "22888"
  }
]
```

可以看到返回数据

```json
[
  {
    "id": 2,
    "username": "admins",
    "password": "888"
  },
  {
    "id": 4,
    "username": "admins22",
    "password": "22888"
  }
]
```

### AutoLogin

基于数据库的记住我，进行自动登录

### 基本原理

1. 认证成功将加密串给浏览器和数据库
2. 再次访问时,浏览器中的加密串与数据库对比,如果查询到对应信息则访问成功

![](https://img.imgdb.cn/item/6079727b8322e6675c5beb33.png)

### 具体实现

1. 创建数据库表(也可以使用自动生成的表)

```sql
CREATE TABLE `persistent_logins`
(
    `username`  varchar(64) NOT NULL,
    `series`    varchar(64) NOT NULL,
    `token`     varchar(64) NOT NULL,
    `last_used` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE
        CURRENT_TIMESTAMP,
    PRIMARY KEY (`series`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8;
```

2. 编写配置类

注入数据源，配置操作数据库对象

```java

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
    
    
    //...
}
```

3. 登录页面表单设置

其中 value 固定为 remember-me

```html
<form action="/user/login" method="post">
    用户名：<input type="text" name="username"/><br/>
    密  码：<input type="text" name="password"/><br/>
    <input type="checkbox" value="remember-me">自动登录
    <input type="submit" value="login">
</form>
```




### AuthorityByDataBase