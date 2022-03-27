package leetcode;

import java.util.Arrays;

public class Case1470 {

    public static int[] shuffle(int[] nums, int n) {
        int[] ret = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < n; i++, idx++) {
            ret[idx] = nums[i];
            idx++;
            ret[idx] = nums[n + i];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        System.out.println(Arrays.toString(shuffle(nums, n)));
    }
}
