package offer;

public class Case53 {

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int count = 0;
        while (l <= r) {
            int idx = l + (r - l) / 2;
            int tmp = nums[idx];
            if (tmp == target) {
                count++;
                int i = idx - 1, j = idx + 1;
                while (i >= 0 && nums[i] == target) {
                    i--;
                    count++;
                }
                while (j < nums.length && nums[j] == target) {
                    j++;
                    count++;
                }
                break;
            } else if (tmp < target) {
                l = idx + 1;
            } else {
                r = idx - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(search(nums, 9));
        System.out.println(search(nums, 8));
    }
}
