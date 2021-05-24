package objects;

/**
 * @Date : 2020/1/31  16:17
 * @Author: Halo
 * @File : ShowProperties
 * @Description:
 **/

public class ShowProperties {
    public static void main(String[] args) {
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
    }
}
