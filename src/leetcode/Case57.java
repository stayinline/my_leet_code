package leetcode;

public class Case57 {

    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                break;
            }
        }
        return new int[]{nums[l], nums[r]};
    }
}
