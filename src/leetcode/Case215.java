package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Case215 {

    static class Solution {
        public static int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(k);

            for (int i = 0; i < nums.length; i++) {
                if (i < k) {
                    queue.add(nums[i]);
                } else {
                    if (nums[i] > queue.peek()) {
                        queue.poll();
                        queue.add(nums[i]);
                    }
                }
            }
            return queue.peek();
        }

        public static void main(String[] args) {
            int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
            System.out.println(findKthLargest(nums, 4));
        }
    }
}
