package leetcode;

public class Case42 {

    public static int trap(int[] height) {
        int ans = 0;
        int i = 0, j = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (i < j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);

            // 存储的雨水量是由较小的一方决定的，木桶短板
            if (leftMax < rightMax) {
                ans += leftMax - height[i];
                i++;
            } else {
                ans += rightMax - height[j];
                j--;
            }
        }
        return ans;
    }
}
