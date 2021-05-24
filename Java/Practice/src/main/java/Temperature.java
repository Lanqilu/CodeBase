import java.util.Scanner;

/**
 * @Date 2019/12/23 - 下午 11:05
 **/
public class Temperature {
//    private float F = 0;
//    private float C = 0;

    public float write(){
        Scanner in = new Scanner(System.in);
        float C = in.nextFloat();
        return C;
    }

    public static void main(String[] args){
        float c = new Temperature().write();
        float f = (float) ((9.0 / 5.0) * c + 32);
        System.out.println(f);
    }
}
