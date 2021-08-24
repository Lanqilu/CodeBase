package solutions;

import java.util.Arrays;

/**
 * @author Halo
 * @date Created in 2021/08/24 下午 02:07
 * @description
 */
class q1646 {
    static int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i / 2] + i % 2 * nums[i / 2 + 1];
        }
        return Arrays.stream(nums).max().getAsInt();
    }

    public static void main(String[] args) {
        int maximumGenerated = getMaximumGenerated(3);
        System.out.println(maximumGenerated);
    }
}
