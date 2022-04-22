package offer2;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Case7 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ret;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> list = twoSum(nums, 0 - nums[i], i + 1);
            for (List<Integer> ans : list) {
                ans.add(nums[i]);
                ret.add(ans);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return ret;
    }

    public static List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return ret;
        }

        int i = start, j = nums.length - 1;
        while (i < j) {
            int left = nums[i], right = nums[j];
            int tmp = nums[i] + nums[j];
            if (tmp < target) {
                while (i < j && nums[i] == left) i++;
            } else if (tmp > target) {
                while (i < j && nums[j] == right) j--;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(left);
                list.add(right);
                ret.add(list);
                while (i < j && nums[j] == right) j--;
                while (i < j && nums[i] == left) i++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, -1, 0};
        System.out.println(threeSum(nums));
//        System.out.println(twoSum(nums, 0, 1));
    }
}
