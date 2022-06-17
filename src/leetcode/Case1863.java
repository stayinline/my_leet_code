package leetcode;

public class Case1863 {


    int sum = 0;

    public int subsetXORSum(int[] nums) {
        // 边界校验
        if (nums == null || nums.length == 0) {
            return sum;
        }
        dfs(nums, 0, 0);
        return sum;
    }

    public void dfs(int[] nums, int idx, int tmp) {
        if (idx >= nums.length) {
            sum += tmp;
            return;
        }
        // 选择当前元素
        dfs(nums, idx + 1, tmp ^ nums[idx]);

        // 不选择当前元素
        dfs(nums, idx + 1, tmp);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        int sum = new Case1863().subsetXORSum(nums);
        System.out.println(sum);
    }
}
