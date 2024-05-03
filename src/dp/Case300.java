package dp;


import java.util.Arrays;

public class Case300 {


    public static int lengthOfLIS(int[] nums) {
        // 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 这种解法的思路是找到每个元素的最长递增数组，记录到ans中，ans的最大值就是最长子数组
     * 但是，寻找最长递增子序列的方式是有问题的，如果nums中所有元素严格递增，那么这种方式没问题
     * 对于：[0,1,0,3,2,3] 这种第一个元素的最长递增子序列显然是[0,1,2,3]
     * 而不是[0,1,3]
     */
    public static int lengthOfLISError(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int cur = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > cur) {
                    count++;
                    cur = nums[j];
                }
            }
            ans[i] = count;
        }
        int res = 0;
        for (int i = 0; i < ans.length; i++) {
            res = Math.max(res, ans[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(nums));
    }
}
