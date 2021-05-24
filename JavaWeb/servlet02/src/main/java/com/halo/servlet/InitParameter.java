package com.halo.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * @Date: 2020年05月30日  19:49
 * @Description:
 **/
public class InitParameter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //读取数据类
        ServletContext servletContext = this.getServletContext();

        //获取初始化参数
        String url = servletContext.getInitParameter("url");
        resp.getWriter().print(url);

        new Properties();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
