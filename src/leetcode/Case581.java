package leetcode;

public class Case581 {

    public static int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        // 分别记录目标子数组的最大值和最小值，所以先初始化
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        // 找到目标数组的左右下标，即[left,right]区间为目标子数组
        // right - left + 1为目标数组的长度
        int right = -1, left = -1;

        // 为什么是一次遍历就能找到这个子数组？
        // 什么最短连续子数组？
        // 如果说找这个数组里面的最大值和最小值，然后找到这个最大值和最小值的下标的开区间的长度，是不是就会了
        // [2, 6, 4, 8, 10, 9, 15] 就是找到 6 和 10 的下标，然后计算下标之间的距离
        // 注意细节：找的时候是双指针，一左一右寻找
        for (int i = 0, j = len - 1; i < len && j >= 0; i++, j--) {
            if (max > nums[i]) {
                right = i;
            } else {
                max = nums[i];
            }
            if (min < nums[j]) {
                left = j;
            } else {
                min = nums[j];
            }
        }
        // 右区见下标为-1，说明最大值就是nums数组后一个元素
        // 也就是说这个区间是有序的，不需要变动，所以直接返回0
        return right == -1 ? 0 : right - left + 1;
    }




    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
//        System.out.println(findUnsortedSubarray(nums));
//        int[] nums1 = {5, 4, 3, 2, 1};
//        System.out.println(findUnsortedSubarray(nums1));
        int[] nums2 = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums2));

    }
}
