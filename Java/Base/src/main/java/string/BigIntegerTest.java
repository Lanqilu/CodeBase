package string;

import java.math.BigInteger;

/**
 * @author Halo
 * @date Created in 2021/05/20 12:24 PM
 * @descriptiTest*/
public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger bi = new BigInteger("1234567890");
        System.out.println(bi.pow(5)); // 2867971860299718107233761438093672048294900000

        BigInteger n = new BigInteger("999999").pow(99);
        float f = n.floatValue();
        System.out.println(f);
    }
}
