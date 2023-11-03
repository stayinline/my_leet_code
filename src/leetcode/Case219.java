package leetcode;

import java.util.*;

public class Case219 {

    /**
     * 这种方式可行的原因在于：题目要的是abs(i - j) <= k
     * 所以对于相等的值，最近的[i,j]就是从左至右逐个遍历，j一定比j+1距离i更近
     * 所以，只要下一个等于nums[i]的下标j满足bs(i - j) <= k，直接return即可
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, List<Integer>> map = getIdxMap(nums);
        for (Integer num : map.keySet()) {
            List<Integer> list = map.get(num);
            int size = list.size();
            if (size >= 2) {
                for (int i = 0; i < size; i++) {
                    for (int j = i + 1; j < size; j++) {
                        if (Math.abs(list.get(i) - list.get(j)) <= k) {
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }

    public static Map<Integer, List<Integer>> getIdxMap(int[] nums) {
        Map<Integer, List<Integer>> ans = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = ans.get(nums[i]);
            if (null != list) {
                list.add(i);
            } else {
                list = new ArrayList<>();
                list.add(i);
            }
            ans.put(nums[i], list);
        }
        return ans;
    }


    /**
     * 暴力法
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 1};

        System.out.println(containsNearbyDuplicate(nums, 2));
    }
}
