package leetcode;

import java.util.HashMap;

public class Case137 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer val : map.keySet()) {
            Integer count = map.get(val);
            if (count == 1) {
                return val;
            }
        }
        return -1;
    }

}
