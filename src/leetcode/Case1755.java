package leetcode;

import java.util.Arrays;

public class Case1755 {


    /**
     * 这种做法的误区在于没有剔除那些对子数组和影响极大的元素，
     * 并且子数组是可以不连续的取值
     *
     * @param nums
     * @param goal
     * @return
     */
    public static int minAbsDifference1(int[] nums, int goal) {
        int sum = 0, min = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                int tmp = Math.abs(sum - goal);
                min = Math.min(tmp, min);
            }
        }
        return min;
    }

    public static int minAbsDifference(int[] nums, int goal) {
        int len = nums.length;
        int len1 = len / 2, len2 = len - len1;
        int[] num1 = new int[1 << len1], num2 = new int[1 << len2];
        for (int i = 0; i < (1 << len1); i++) {
            for (int j = 0; j < len1; j++) {
                if (((i >> j) & 1) == 1) {
                    num1[i] += nums[j];
                }
            }
        }
        for (int i = 0; i < (1 << len2); i++) {
            for (int j = 0; j < len2; j++) {
                if (((i >> j) & 1) == 1) {
                    num2[i] += nums[j + len1];
                }
            }
        }
        Arrays.sort(num1);
        Arrays.sort(num2);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < num1.length; i++) {
            int target = goal - num1[i];
            int idx = binarySearch(num2, target);
            res = Math.min(res, Math.abs(num1[i] + num2[idx] - goal));
            if (idx + 1 < num2.length) {
                res = Math.min(res, Math.abs(num1[i] + num2[idx + 1] - goal));
            }
        }
        return res;

    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private static void splitNum(int[] nums, int index, int len, int[] arr) {
        // arr[0]: 一个数也没有的, 就是 0
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) { // 依次考察状态 i 上的每一位上的 1
                    arr[i] = arr[i ^ (1 << j)] + nums[j + index];
                    break; // 这个 break 很重要, 提速了!!!
                }
            }
        }
    }

    public static int minAbsDifference2(int[] nums, int goal) {
        if (nums == null || nums.length == 0) {
            return goal;
        }
        int half = nums.length / 2;
        int[] l = new int[1 << half];
        int[] r = new int[1 << (nums.length - half)];
        splitNum(nums, 0, half, l);
        splitNum(nums, nums.length >> 1, nums.length - half, r);
        Arrays.sort(l);
        Arrays.sort(r);
        int ans = Math.abs(goal);
        // le 数组从 0 开始
        // re 数组从最大开始, 相当于双指针了
        int re = r.length - 1;
        for (int i = 0; i < l.length; i++) { // 从 le 数组里取出每一个数, 到 re 里找最匹配的数
            int rest = goal - l[i];
            // 从最后一个开始, 最后一个是最大值, 必然 gap 最大
            while (re > 0 && Math.abs(rest - r[re - 1]) <= Math.abs(rest - r[re])) {
                re--;
            }
            ans = Math.min(ans, Math.abs(rest - r[re]));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {7, -9, 15, -2};
        System.out.println(minAbsDifference(nums, -5));
        System.out.println(Math.abs(-4 - (-5)));
        System.out.println(1 << 1);
        System.out.println(1 << 2);
        System.out.println(1 << 3);

        System.out.println(4 >> 1);
        System.out.println(8 >> 1);
    }
}
