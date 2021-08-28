package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Case57 {

    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                break;
            }
        }
        return new int[]{nums[l], nums[r]};
    }

    public static int[][] findContinuousSequence(int target) {
        int l = 1;
        int r = 2;
        int sum = 3;
        List<int[]> res = new ArrayList<>();

        while (l < r) {
            if (sum > target) {
                // 收缩左窗口边界，注意：必须是先将左边界值减掉，然后再收缩
                sum -= l;
                l++;
            } else if (sum < target) {
                // 扩张右窗口边界,注意：必须是先收缩，然后再将左边界值减掉
                r++;
                sum += r;
            } else {
                // 窗口内的元素和==target，记录所有元素
                int[] tmp = new int[r - l + 1];
                for (int k = l; k <= r; k++) {
                    tmp[k - l] = k;
                }
                res.add(tmp);
                // 记录之后收缩左窗口边界
                sum -= l;
                l++;
            }

        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] ret = findContinuousSequence(9);
        System.out.println(Arrays.deepToString(ret));
    }
}
