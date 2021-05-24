package control;

/**
 * @Date : 2020/1/31  17:32
 * @Author: Halo
 * @File : ListCharacters
 * @Description: for循环
 **/


public class ListCharacters {
    public static void main(String[] args) {

        for (char c = 0; c < 128; c++) {
            if (Character.isLowerCase(c)) {
                System.out.println("value: " + (int) c +
                        " character: " + c);
            }
        }
    }
}
