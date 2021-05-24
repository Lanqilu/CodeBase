package string;

public class ToUpperCase {
    public static void main(String[] args) {
        String s1 = "Hello";
        System.out.println(s1); // Hello
        String s2 = s1.toUpperCase();
        System.out.println(s1); // Hello
        System.out.println(s2); // HELLO
    }
}