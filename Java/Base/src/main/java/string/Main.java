package string;

public class Main {
    public static void main(String[] args) {
        double x = -123.45;
        assert x >= 0 : "x must >= 0";
        System.out.println(x);
    }
}