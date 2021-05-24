package com.halo.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Date: 2020年05月30日  19:57
 * @Description:
 **/
public class Demo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //读取数据类
        ServletContext servletContext = this.getServletContext();

        //请求转发，路径不发生变化；重定向路径会发生变化
        servletContext.getRequestDispatcher("/gp").forward(req,resp);
        System.out.println("进入Demo4");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
