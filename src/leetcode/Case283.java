package leetcode;

public class Case283 {


    public static void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
    }
}
