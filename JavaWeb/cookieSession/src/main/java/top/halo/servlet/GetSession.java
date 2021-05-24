package top.halo.servlet;

import top.halo.poji.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Date: 2020年06月05日  18:49
 * @Description:
 **/
public class GetSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("gbk");
        resp.setCharacterEncoding("gbk");

        //得到Session
        HttpSession session = req.getSession();

        //取Session
        Person person = (Person) session.getAttribute("name");
        System.out.println("person.toString() = " + person.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
