package solutions;

/**
 * @author Halo
 * @date Created in 2021/08/24 下午 06:26
 * @description
 */
class q0034 {
    static int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        // 使用二分法查找
        while (low <= high) {
            mid = (low + high) / 2;
            // 查找出一个值，然后左右扩展范围
            if (nums[mid] == target) {
                int lowRes = mid;
                int highRes = mid;
                // 注意数组越界
                while (lowRes >= 0 && nums[lowRes] == target) {
                    lowRes--;
                }
                while (highRes <= nums.length - 1 && nums[highRes] == target) {
                    highRes++;
                }
                return new int[]{lowRes + 1, highRes - 1};
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2};
        int target = 1;
        for (int i : searchRange(test, target)) {
            System.out.println(i);
        }
    }
}
