package leetcode;


import java.util.Arrays;

public class Case189 {
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        int[] tmp = new int[len];

        for (int i = 0; i < len; i++) {
            tmp[(i + k) % len] = nums[i];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = tmp[i];
        }
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k  == 0) {
            return;
        }
        reverse(nums, 0, nums.length-1 - k);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        rotate(nums,2);
        System.out.println(Arrays.toString(nums));
    }
}
