package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Case454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                for (int k = 0; k < nums3.length; k++) {
                    for (int l = 0; l < nums4.length; l++) {
                        if (nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0) {
                            count++;
                        }

                    }
                }
            }

        }
        return count;
    }

    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        // key： a+b，value：a+b 出现的次数
        Map<Integer, Integer> countAB = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                countAB.put(a + b, countAB.getOrDefault(a + b, 0) + 1);
            }
        }
        int ans = 0;
        for (int c : C) {
            for (int d : D) {
                // 只需要看map中是否包含 -(c + d)) 即可
                // -(c + d)) = -c-d
                if (countAB.containsKey(-c - d)) {
                    ans += countAB.get(-c - d);
                }
            }
        }
        return ans;
    }

}
