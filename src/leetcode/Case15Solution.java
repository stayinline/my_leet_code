package leetcode;

import java.util.*;

public class Case15Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> two = twoSum(nums, i + 1, 0 - nums[i]);
            for (List<Integer> tuple : two) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }


    public List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int l = start, r = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (l < r) {
            int left = nums[l], right = nums[r];
            int tmpSum = left + right;
            if (tmpSum < target) {
                //去掉重复元素
                while (l < r && nums[l] == left) l++;
            } else if (tmpSum > target) {
                while (l < r && nums[r] == right) r--;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(left);
                list.add(right);
                res.add(list);
                while (l < r && nums[l] == left) l++;
                while (l < r && nums[r] == right) r--;
            }
        }
        return res;
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        res ^= n;
        for (int i = 0; i < n; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        int[] nums2 = {-1, 2, 1, 0, -4, -1};
//        StopWatchUtils.start();
//        List<List<Integer>> lists = new Case15Solution().threeSum(nums);
//        System.out.println(lists + "time:" + StopWatchUtils.stopAndGetTimeMillis());
//
//        List<List<Integer>> lists2 = new Case15Solution().threeSum(nums2);
//        System.out.println(lists2);

//        List<List<Integer>> lists = threeSum2(nums2);
//        System.out.println(lists);
    }
//
//    /会有重复元素/
//    public static List<List<Integer>> threeSum2(int[] nums) {
//        List<List<Integer>> ret = new ArrayList<>();
//        int len = nums.length;
//
//        for (int i = 0; i < len; i++) {
//            List<List<Integer>> two = getTwo2(nums, -nums[i]);
//            if (two.size() > 0) {
//                two.add(nums[i]);
//                ret.add(two);
//            }
//        }
//        return ret;
//
//    }
//
//    public static List<List<Integer>> getTwo2(int[] nums, int target) {
//        List<List<Integer>> ret = new ArrayList<>();
//
//        int len = nums.length;
//
//        for (int i = 0; i < len; i++) {
//            List<Integer> list = new ArrayList<>();
//            for (int j = 0; j < len; j++) {
//                int num1 = nums[i], num2 = nums[j];
//                int sum = num1 + num2;
//                if (i != j && sum == target) {
//                    if (list.size() > 0 && list.get(0) == num1)
//                        list.add(num1);
//                    list.add(num2);
//                }
//            }
//
//        }
//        return ret;
//    }
}
