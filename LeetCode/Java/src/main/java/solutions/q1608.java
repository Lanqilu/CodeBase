package solutions;

/**
 * @author Halo
 * @date Created in 2021/08/24 下午 05:56
 * @description 特殊数组的特征值
 */

class q1608 {
    /**
     * 暴力法
     */
    static int specialArray(int[] nums) {
        int length = nums.length;
        int count = 0;
        for (int i = 0; i <= length; i++) {
            for (int num : nums) {
                if (num >= i) {
                    count++;
                }
            }
            if (count == i) {
                return count;
            }
            count = 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = {0,0};
        int res = specialArray(test);
        System.out.println(res);
    }
}
