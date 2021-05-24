package com.halo.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Date: 2020年05月30日  10:20
 * @Description:
 **/
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        this.getInitParameter();  //初始化参数
//        this.getServletConfig();  //Servlet配置
//        this.getServletContext(); //Servlet上下文

        ServletContext servletContext = this.getServletContext();//web容器在启动的时候,它会为每个web程序都创建一个对应的ServletContext对象
        /*
        * 应用
        * 共享数据：我在这个Servlet中保存的数据，可以在另外一个Servlet中拿到，可以保存一些数据
        *
        * */

        //放置数据类
        String username = "halo";
        servletContext.setAttribute("username",username);//将一个数据保存在ServletContext中

        System.out.println("HelloServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
