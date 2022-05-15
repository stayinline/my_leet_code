package leetcode;

import java.util.Arrays;

public class Case922 {
    /**
     * 错误的解法
     *
     * @param nums
     * @return
     */
    public static int[] sortArrayByParityII1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        for (int i = 0, j = nums.length - 1; i < j; i += 2, j -= 2) {
            while (i < nums.length && i % 2 == 0 && nums[i] % 2 == 0) {
                i += 2;
            }
            while (j >= 0 && j % 2 == 1 && nums[j] % 2 == 1) {
                j -= 2;
            }

            // 一次跳跃两个，会导致i<j的时候依然符合要求
            if (i < nums.length && j >= 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return nums;
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (nums[i] % 2 == 1) {
                while (nums[j] % 2 == 1) {
                    j += 2;
                }
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 7};
        System.out.println(Arrays.toString(sortArrayByParityII1(nums)));
    }
}
