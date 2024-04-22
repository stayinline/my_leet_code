package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Case15 {


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> two = twoSum(nums, i + 1, -nums[i]);
            for (List<Integer> tuple : two) {
                tuple.add(nums[i]);
                ans.add(tuple);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return ans;
    }

    // 结果集不允许重复，所以nums需要是有序的
    public static List<List<Integer>> twoSum(int[] nums, int start, int target) {

        List<List<Integer>> ans = new ArrayList<>();


        for (int i = start, j = nums.length - 1; i < j; ) {
            int tmp = nums[i] + nums[j];
            int left = nums[i];
            int right = nums[j];
            if (tmp < target) {
                while (i < j && nums[i] == left) {
                    i++;
                }
            } else if (tmp > target) {
                while (i < j && nums[j] == right) {
                    j--;
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                ans.add(list);

                while (i < j && nums[i] == left) {
                    i++;
                }

                while (i < j && nums[j] == right) {
                    j--;
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
