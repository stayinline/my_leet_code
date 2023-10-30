package leetcode;

import java.util.Arrays;

public class Case88 {

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; i < m + n; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }

    public void mergeOfficial(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        while (p1 < m || p2 < n) {
            int cur;
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; i++) {
            nums1[i] = sorted[i];
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m + n];
        int i = 0, j = 0, k = 0;
        for (; i < m && j < n; k++) {
            if (nums1[i] <= nums2[j]) {
                tmp[k] = nums1[i];
                i++;

            } else if (nums1[i] > nums2[j]) {
                tmp[k] = nums2[j];
                j++;
            }

        }

        if (i >= m) {
            while (j < n) {
                tmp[k] = nums2[j];
                j++;
                k++;
            }
        } else {
            while (i < m) {
                tmp[k] = nums1[i];
                i++;
                k++;
            }
        }


        for (int t = 0; t < m + n; t++) {
            nums1[t] = tmp[t];
        }
    }

}
