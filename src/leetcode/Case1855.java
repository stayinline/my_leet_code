package leetcode;

public class Case1855 {

    public static int maxDistance(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return 0;
        }
        int max = 0;

        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] <= nums2[j]) {
                max = Math.max(max, j - i);
                j++;
            } else {
                i++;
            }
        }
        return max;
    }


    /**
     * 暴力法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxDistance1(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i; j < nums2.length; j++) {
                if (nums1[i] <= nums2[j]) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums1 = {55, 30, 5, 4, 2};
        int[] nums2 = {100, 20, 10, 10, 5};
        System.out.println(maxDistance(nums1, nums2));
    }
}
