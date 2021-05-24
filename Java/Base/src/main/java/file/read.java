package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Date : 2020/2/10  18:00
 * @Author: Halo
 * @File : read
 * @Version : v1.0
 * @Description: 读取文本文件
 **/
public class read {
    public static void main(String[] args) throws IOException {
        BufferedReader fd =new BufferedReader(new FileReader("./text.txt"));
        String line = fd.readLine();
        System.out.println(line);
    }
}
