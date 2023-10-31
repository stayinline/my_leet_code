package leetcode;

import java.util.Arrays;

public class Case26 {

    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[j + 1] = nums[i + 1];
                j++;
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        removeDuplicates(a);
        System.out.println(Arrays.toString(a));
    }
}
