package leetcode;

import java.util.Arrays;

public class Case34 {

    public static int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target < nums[mid]) {
                r = mid - 1;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                l = mid;
                while (l > 0 && nums[l] == nums[l - 1]) {
                    l--;
                }
                r = mid;
                while (r < nums.length - 1 && nums[r] == nums[r + 1]) {
                    r++;
                }
                return new int[]{l + 1, r - 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] range = searchRange(nums, 6);
        System.out.println(Arrays.toString(range));
    }

}
