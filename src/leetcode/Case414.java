package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Case414 {

    public static int thirdMax(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > a) {
                c = b;
                b = a;
                a = nums[i];
            } else if (a > nums[i] && nums[i] > b) {
                c = b;
                b = nums[i];
            } else if (b > nums[i] && nums[i] > c) {
                c = nums[i];
            }
        }
        if (nums.length == 2) {
            return a;
        }
        return c;
    }

    public static int thirdMaxOffical(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && num > b) {
                c = b;
                b = num;
            } else if (b > num && num > c) {
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
//        System.out.println(thirdMax(nums));
        System.out.println(thirdMaxOffical(nums));

    }
}
