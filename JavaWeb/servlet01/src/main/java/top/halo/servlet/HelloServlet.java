package top.halo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Date: 2020年05月28日  23:24
 * @Description: HelloServlet
 **/
public class HelloServlet extends HttpServlet {

    //get和post只是请求方式的不同，业务逻辑一样，可以相互调用

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入doGet方法");
        // ServletOutputStream outputStream = resp.getOutputStream();
        // 响应流
        PrintWriter writer = resp.getWriter();
        writer.print("hello,servlet");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
