package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Case1 {

    /**
     * 这种写法的改进之处在于，map.put之前先判断是否存在
     * 如果存在，那么直接return了
     * 如果不存在，说明当前哈希槽还没有put过，直接put当前值即可
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int t2 = target - nums[i];
            if (map.containsKey(t2)) {
                ans[0] = map.get(t2);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }


    public static int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    ans[0] = j;
                    ans[1] = i;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 这种写法的在错误之处在于：indexMap中存放的是已经全部被覆盖后的值
     * target=6，nums:[3,3]
     * 对应的map-> map:[{3:0},{3:1}] -> [{3:1}]
     * 然后再遍历nums，从map中找 target-nums[i] 是否存在，显然已经丢掉了很多数据
     */
    public static int[] twoSum3(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = getMapIdx(nums);
        for (int i = 0; i < nums.length; i++) {
            int t2 = target - nums[i];
            if (map.containsKey(t2)) {
                ans[0] = map.get(t2);
                ans[1] = i;
                break;
            }
        }
        return ans;
    }

    public static Map<Integer, Integer> getMapIdx(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        return map;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }
}
