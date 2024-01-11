package leetcode;

import java.util.Arrays;

public class Case1103 {
    public static int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int cur = 1, idx = 0;
        while (candies > 0) {
            ans[idx] += Math.min(candies, cur);
            candies -= cur;
            cur++;
            idx++;
            idx %= num_people;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(7, 4)));
        System.out.println(Arrays.toString(distributeCandies(10, 3)));
    }

}
