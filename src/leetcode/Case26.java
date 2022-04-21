package leetcode;

import java.util.Arrays;

public class Case26 {

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        removeDuplicates(a);
        System.out.println(Arrays.toString(a));
    }
}
