package top.halo.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Date: 2020年06月01日  23:37
 * @Description:
 **/
public class ImgServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //浏览器5s自动刷新
        resp.setHeader("refresh","3");

        //在内存中创建图片
        BufferedImage bufferedImage = new BufferedImage(80,20,BufferedImage.TYPE_3BYTE_BGR);
        //得到图片
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();//笔
        //设置图片的背景颜色
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,80,20);
        //给图片写数据
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font(null, Font.BOLD, 20));
        graphics.drawString(makeNum(),0,20);

        //告诉浏览器，这个请求用浏览器打开
        resp.setContentType("image/jpeg");
        //网站缓存，不让浏览器设置缓存
        resp.setDateHeader("expires",-1);
        //缓存控制
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        //把图片写给浏览器
        boolean write = ImageIO.write(bufferedImage,"jpg", resp.getOutputStream());

    }

    //生成随机数
    private String makeNum(){
        Random random = new Random();
        String num = random.nextInt(9999999) + "";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 7 - num.length(); i++) {
            stringBuffer.append("0");
        }
        num = stringBuffer.toString() + num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
