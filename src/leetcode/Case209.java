package leetcode;


/**
 * nums是无序的，结果要求的是最小连续子数组，所以不能排序，排序会打乱数组元素
 */
public class Case209 {

    // 优化之后
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, tmpSum = 0;
        for (int i = 0, j = 0; j < nums.length; ) {
            tmpSum += nums[j];
            // 这里采用一个循环，逐个吧子数组中满足条件的跳过，直接就能缩小滑动窗口的扫描范围
            while (tmpSum >= target) {
                ans = Math.min(ans, j - i + 1);
                tmpSum -= nums[i];
                i++;
            }
            j++;

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    /**
     * 可以AC，但是复杂度太高，滑动窗口更新的时候还是会扫描大量重复元素
     */
    public static int minSubArrayLen1(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, tmpSum = 0;
        for (int i = 0, j = 0; j < nums.length; ) {
            tmpSum += nums[j];
            if (tmpSum >= target) {
                ans = Math.min(ans, j - i + 1);
                i++;
                j = i;
                tmpSum = 0;
            } else {
                j++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));

    }
}
