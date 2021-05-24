package string;

/**
 * @author Halo
 * @date Created in 2021/05/19 7:13 PM
 * @description
 */
public class ValueOf {
    public static void main(String[] args) {
        System.out.println(String.valueOf(new Object()));
        String str = "sun.arch.data.model"; // 系统类型
        System.out.println(Integer.getInteger(str)); // 64
        System.out.println(System.getProperty(str)); // 64
    }
}
