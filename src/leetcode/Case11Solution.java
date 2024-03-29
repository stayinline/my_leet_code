package leetcode;

public class Case11Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            // 木桶理论短板效应
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            // 经典二分法的思想来挪动指针
            if (height[l] < height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ret=new int[10];
        for (int i = 2; i < 5; i++) {
            System.out.println(Integer.toString(9, i));
        }
    }
}
