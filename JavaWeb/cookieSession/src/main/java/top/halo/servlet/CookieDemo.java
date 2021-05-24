package top.halo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @Date: 2020年06月05日  17:36
 * @Description:
 **/
public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("gbk");
        resp.setCharacterEncoding("gbk");

        PrintWriter out = resp.getWriter();

        //服务端从客户端获取Cookie
        Cookie[] cookies = req.getCookies();

        //判断Cookie是否存在
        if (cookies != null) {
            out.write("上次访问时间是:");
            //遍历数组
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                //获取Cookie名字
                if(cookie.getName().equals("time")){
                    //获取Cookie中的值
                    long time = Long.parseLong(cookie.getValue());
                    Date date = new Date(time);
                    out.write(URLDecoder.decode(date.toLocaleString(),"utf-8"));
                }


            }
        }else {
            out.write("第一次访问");
        }

        //服务器给客户端响应Cookie
        Cookie cookie = new Cookie("time", URLEncoder.encode(System.currentTimeMillis()+"","utf-8"));

        //cookie有效期
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

