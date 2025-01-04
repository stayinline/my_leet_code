package dp;

public class Case198 {

    public static int rob2(int[] nums) {

        int a = 0, b = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                a += nums[i];
            } else {
                b += nums[i];
            }
        }
        return Math.max(a, b);
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        //思路就是每个小区间中取合法的最大值，然后求累加和
        int a = nums[0], ans = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            int c = ans;//记录上一次拿取的最大值
            ans = Math.max(a + nums[i], ans);
            a = c;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int[] nums2 = {2, 1, 1, 2};
        System.out.println(rob(nums));
    }
}
