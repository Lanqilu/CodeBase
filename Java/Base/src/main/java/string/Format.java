package string;

/**
 * @author Halo
 * @date Created in 2021/05/18 11:59 PM
 * @description
 */
public class Format {
    public static void main(String[] args) {
        String s = "Hi %s, your score is %d!";
//        System.out.println(s.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));
    }
}


