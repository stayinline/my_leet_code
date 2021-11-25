package offer;

import java.util.Arrays;

public class Case21 {
    public static int[] exchange(int[] nums) {
        int i = 0;// 找偶数
        int j = nums.length - 1; // 找奇数
        while (i <= j) {
            while (i < j && nums[i] % 2 == 1) {
                i++;
            }
            while (j > i && nums[j] % 2 == 0) {
                j--;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(exchange(nums)));
    }
}
