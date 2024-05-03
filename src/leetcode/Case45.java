package leetcode;

public class Case45 {

    /**
     * 题目保证可以到达 nums[n-1]!!!
     * 所以，贪心法，每一步选择最大的跳跃到达next,
     * 然后一次遍历，每一次跳跃都记录，累计最小值就
     */
    public static int jump(int[] nums) {
        int n = nums.length;
        int maxIdx = 0;
        int next = 0;
        int step = 0;
        for (int i = 0; i < n - 1; i++) {
            maxIdx = Math.max(maxIdx, i + nums[i]);
            if (i == next) {
                next = maxIdx;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {


        int[] nums = {2, 3, 1, 1, 4};

        System.out.println(jump(nums));
    }
}
