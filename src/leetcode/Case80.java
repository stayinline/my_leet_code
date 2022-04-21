package leetcode;

public class Case80 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        // 小于等于2的不需要做任何处理
        if (n <= 2) {
            return n;
        }
        // 从下标2的位置开始遍历
        int i = 2;
        for (int j = 2; j < n; j++) {
            // 用-2来卡住每个元素出现的次数
            // i指向nums[i-2]出现的第三次，所以直接覆盖，然后再后移
            if (nums[i - 2] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}
