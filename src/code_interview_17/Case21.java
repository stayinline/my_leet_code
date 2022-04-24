package code_interview_17;

import java.util.ArrayList;
import java.util.List;

public class Case21 {

    /**
     * 这种做法的问题是，如果出现逆序数组：[3，1，2，1，2，0，2]
     * 右边永远找不到一个比height[0] 大的数，所以就整个被丢弃了
     *
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ret = 0;
        int i = 0, j = 1;
        while (j < height.length) {
            if (height[j] < height[i]) {
                List<Integer> list = new ArrayList<>();
                while (j < height.length && height[j] < height[i]) {
                    list.add(height[j]);
                    j++;
                }
                if (j < height.length && !list.isEmpty()) {
                    int min = Math.min(height[i], height[j]);
                    for (Integer num : list) {
                        ret += (min - num);
                    }
                    i = j;
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }
        return ret;
    }

    /**
     * 双指针左右端点各一个，
     * 需要记录两个最大值：leftMax，rightMax，以这两个作为标杆，
     * 就能算出height[i]、height[j]的存水量，
     * 然后，双指针收拢，逐个计算height[i]、height[j]的存水量，并累加
     * 直到双指针相遇
     * <p>
     * 这个算法的思路在于逐个计算，而不是去找到每个由双指针围起来的低洼
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int ans = 0;
        int i = 0, j = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (i < j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);

            // 存储的雨水量是由较小的一方决定的，木桶短板
            if (height[i] < height[j]) {
                ans += leftMax - height[i];
                i++;
            } else {
                ans += rightMax - height[j];
                j--;
            }
        }
        return ans;
    }

    public static int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ret = 0;
        int i = 0, j = height.length - 1;
        int lMax = 0, rMax = 0;
        while (i < j) {
            lMax = Math.max(height[i], lMax);
            rMax = Math.max(height[j], rMax);
            if (height[i] < height[j]) {
                ret += lMax - height[i];
                i++;
            } else {
                ret += rMax - height[j];
                j--;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap2(height));
    }
}
