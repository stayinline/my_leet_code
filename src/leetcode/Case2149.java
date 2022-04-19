package leetcode;


import java.util.Arrays;

/**
 * [3,1,-2,-5,2,-4]
 * [3,-2,1,-5,2,-4]
 */
public class Case2149 {

    /**
     * 思维误区：
     * 想在原数组上直接置换，是不可能的
     *
     * @param nums
     * @return
     */
    public static int[] rearrangeArray1(int[] nums) {
        int i = 0, j = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if (cur % 2 == 0) {
                // +
                while (i < nums.length && nums[i] < 0) {
                    i++;
                }
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

            } else {
                // -
                while (j < nums.length && nums[j] > 0) {
                    j++;
                }
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

            }


        }
        return nums;
    }


    /**
     * 新创建一个数组
     * 双指针寻找正数和负数
     *
     * @param nums
     * @return
     */
    public static int[] rearrangeArray(int[] nums) {
        int[] ret = new int[nums.length];
        int i = 0, j = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if (cur % 2 == 0) {
                // +
                while (i < nums.length && nums[i] < 0) {
                    i++;
                }
                ret[cur] = nums[i];
                i++;
            } else {
                // -
                while (j < nums.length && nums[j] > 0) {
                    j++;
                }
                ret[cur] = nums[j];
                j++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }
}
