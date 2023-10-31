package leetcode;

public class Case80 {

    public static int removeDuplicates1(int[] nums) {
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


    public static int removeDuplicates2(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }
        int j = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[j - 2] != nums[i]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    /**
     * j:记录上一个元素
     */
    public static int removeDuplicates(int[] nums) {
        int count = 1, j = 0;
        for (int i = j + 1; i < nums.length; i++) {
            // 连着两个元素相等时，只用判断是否连续出现两次以上，
            // 如果不是，就要用[i]覆盖[j]，并记录出现次数
            // 如果是，i就后移，接着找下一个，将重复的全都跳过
            if (nums[i] == nums[j]) {
                if (count < 2) {
                    j++;
                    nums[j] = nums[i];
                    count++;
                }
            } else {
                // 连着两个元素不相等时，此时j只有两种情况
                // 要么：j=i-1，表示相邻
                // 要么：j指向上一个出现第二次的元素，
                // 此时先把 j++，就进入了下一个判断区间，直接覆盖
                j++;
                nums[j] = nums[i];
                count = 1;
            }
        }
        return j + 1;
    }


    public static void main(String[] args) {
//        int[] nums={3,2,2,3};
//        int ret = removeElement(nums, 3);
//        for (int i=0; i<ret;i++ ) {
//            System.out.println(nums[i]);
//        }

        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] nums2 = {1, 1, 2, 2, 2, 3, 3};
        int ret = removeDuplicates2(nums2);
        for (int i = 0; i < ret; i++) {
            System.out.print(nums2[i] + "->");
        }
    }
}
