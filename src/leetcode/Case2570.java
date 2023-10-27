package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Case2570 {
    public static int[][] mergeArrays1(int[][] nums1, int[][] nums2) {
        int[][] ans = new int[nums1.length + nums2.length][nums1[0].length];
        for (int i = 0, j = 0, k = 0; i < nums1.length && j < nums2.length; k++) {
            if (nums1[i][0] == nums2[j][0]) {
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            } else if (nums1[i][0] > nums2[j][0]) {
                ans[k][0] = nums2[j][0];
                ans[k][1] = nums2[j][1];
                j++;
            } else {
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1];
                i++;
            }

        }
        return ans;

    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            int[] ans = new int[2];
            if (nums1[i][0] == nums2[j][0]) {
                ans[0] = nums1[i][0];
                ans[1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            } else if (nums1[i][0] > nums2[j][0]) {
                ans[0] = nums2[j][0];
                ans[1] = nums2[j][1];
                j++;
            } else {
                ans[0] = nums1[i][0];
                ans[1] = nums1[i][1];
                i++;
            }
            list.add(ans);
        }
        if (i != nums1.length) {
            while (i < nums1.length) {
                int[] ans = new int[2];
                ans[0] = nums1[i][0];
                ans[1] = nums1[i][1];
                list.add(ans);
                i++;
            }
        }
        if (j != nums2.length) {
            while (j < nums2.length) {
                int[] ans = new int[2];
                ans[0] = nums2[j][0];
                ans[1] = nums2[j][1];
                list.add(ans);
                j++;
            }
        }
        return list.toArray(new int[list.size()][2]);

    }


    public static void main(String[] args) {
        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = {{1, 4}, {3, 2}, {4, 5}};

        System.out.println(nums1.length);

        System.out.println(Arrays.toString(mergeArrays(nums1, nums2)));
    }

}
