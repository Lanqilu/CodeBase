package top.halo.servlet;

import top.halo.poji.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Date: 2020年06月05日  18:30
 * @Description:
 **/
public class SessionDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("gbk");
        resp.setCharacterEncoding("gbk");

        //得到Session
        HttpSession session = req.getSession();

        //存信息
        session.setAttribute("name",new Person("Lanqilu",18));

        //获取Session的ID
        String id = session.getId();

        boolean aNew = session.isNew();
        if (aNew) {
            resp.getWriter().write("session创建成功" + id);
        }else {
            resp.getWriter().write("session已经存在" + id);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
