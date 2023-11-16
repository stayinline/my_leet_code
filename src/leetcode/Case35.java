package leetcode;

public class Case35 {

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    public static int searchInsertError(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while (i != j) {
            if (nums[i] > target) {
                return i;
            } else if (nums[j] < target) {
                return j + 1;
            } else if (nums[i] < target) {
                i++;
            } else if (nums[j] > target) {
                j--;
            } else {
                if (nums[i] == target) {
                    return i;
                } else if (nums[j] == target) {
                    return j;
                }
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(searchInsert(nums, 7));
    }
}
