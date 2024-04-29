package leetcode;

public class Case42 {

    // 双指针解法的关键在于，从两端开始向中间遍历的过程中，天然就满足动态规划法中i的左侧最大值，右侧最大值
    // leftMax 是从左往右遍历，符合左指针，
    // rightmax是从右往左遍历，符合右指针，
    // 所以，左右两侧的最大值中的最小值，一定是一个固定的值，就可以用一个变量来记录

    public static int trap2(int[] height) {
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
            //System.out.println("i=" + i + ",lMax=" + leftMax + ",rMax=" + rightMax + ", water_i=" + Math.abs(leftMax - rightMax));
        }
        return ans;
    }

    // 对于每一个下标为i的位置，它能承接的雨水是：
    // water[i]=min(height[i左侧最高的],height[i右侧最高的])-height[i];
    public static int trap(int[] height) {
        int ret = 0;
        int len = height.length;

        for (int i = 0; i < len; i++) {

            // 这里注意，为什么找左右两侧最高的木板，是从j=i开始？
            // 因为对于处于边界的木板，一定是它自己为最值，
            // 所以不能 j=i+1 / j<i ,这样就丢失了当前值i
            int lMax = 0;
            for (int j = 0; j <= i; j++) {
                lMax = Math.max(height[j], lMax);
            }

            int rMax = 0;
            for (int j = i; j < len; j++) {
                rMax = Math.max(height[j], rMax);
            }

            int curWater = Math.min(lMax, rMax) - height[i];
            System.out.println("i=" + i + ",lMax=" + lMax + ",rMax=" + rMax + ", water_i=" + curWater);

            ret += curWater;

        }
        return ret;

    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap2(height));
    }
}
