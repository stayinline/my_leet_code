package leetcode;

import java.util.BitSet;

public class Case287 {

    public static int findDuplicate1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;

    }

    public static int findDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] tmp = new int[nums.length];
        for (int num : nums) {
            if (tmp[num] != 0) {
                return num;
            }
            tmp[num] = num;
        }
        return -1;
    }

    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        BitSet bitSet = new BitSet();
        for (int num : nums) {
            if (bitSet.get(num)) {
                return num;
            }
            bitSet.set(num);
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }
}
