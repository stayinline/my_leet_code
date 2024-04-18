package leetcode;

import java.util.Arrays;

public class Case167 {

    public static int[] twoSum(int[] numbers, int target) {
        int idx1 = -1, idx2 = -1;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                idx1 = i;
                idx2 = j;
                break;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{idx1 + 1, idx2 + 1};
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));
    }
}
