package leetcode;

public class Offer42 {



    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                // sum<0：说明之前的累加和可以丢弃，从当前重新开始
                sum = nums[i];
            } else {
                // sum>0：说明当前值可以累加到sum中
                sum = sum + nums[i];
            }
            // 累加或者更新sum之后，更新res
            res = Math.max(res, sum);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }
}
