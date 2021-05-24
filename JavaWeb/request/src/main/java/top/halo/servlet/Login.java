package top.halo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Date: 2020年06月05日  16:17
 * @Description:
 **/
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String[] parameterValues = req.getParameterValues("hobbies");

        System.out.println("====================================");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("Arrays.toString(parameterValues) = " + Arrays.toString(parameterValues));
        System.out.println("====================================");

        //通过请求转发
        req.getRequestDispatcher("/success.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
