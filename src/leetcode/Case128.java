package leetcode;

import java.util.Arrays;

public class Case128 {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = 1, step = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                step++;
                ans = Math.max(ans, step);
            } else {
                step = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {100, 4, 200, 1, 3, 2};
//        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};


        int[] nums = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};

        System.out.println(longestConsecutive(nums));
    }

}
