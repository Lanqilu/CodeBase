package top.halo.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @Date: 2020年05月31日  23:39
 * @Description:
 **/
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  获取下载文件的路径
        String realPath = "E:\\Project\\CodeBase\\JavaWeb\\response\\src\\main\\resources\\1.png";
        //String realPath = this.getServletContext().getRealPath(filePath);
        System.out.println("下载文件的路径："+ realPath);
        //  下载文件的文件名
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //  浏览器支持
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"utf-8"));
        //  获取下载文件的输入流
        FileInputStream fileInputStream = new FileInputStream(realPath);
        //  创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        //  获取OutPutStream对象
        ServletOutputStream outputStream = resp.getOutputStream();
        //  将文件OutPutStream流写入到buffer缓冲区,使用OutPutStream将缓冲区中的数据输出到客户端
        while ((len=fileInputStream.read(buffer)) != -1){
            outputStream.write(buffer,0,len);
        }
        //  关闭流
        fileInputStream.close();
        outputStream.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
