package solutions;

/**
 * @author Halo
 * @date Created in 2021/05/30 8:49 PM
 * @description 位1的个数
 */
public class q0191 {
    static int hammingWeight1(int n) {
        return Integer.bitCount(n);
    }

    static int bitCount(int i) {
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }

    static int bitCount2(int i) {
        i = (i & 0x55555555) + ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i & 0x0f0f0f0f) + ((i >>> 4) & 0x0f0f0f0f);
        i = (i & 0x00ff00ff) + ((i >>> 8) & 0x00ff00ff);
        i = (i & 0x0000ffff) + ((i >>> 16) & 0x0000ffff);
        return i;
    }

    public static void main(String[] args) {
        // System.out.println("hammingWeight1(0b011010) = " + hammingWeight1(0b011010));

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (bitCount(i) != bitCount2(i)) {
                System.err.println("出错");
                break;
            }
        }
        System.out.println("顺利结束");
    }
}



