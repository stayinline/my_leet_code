package leetcode;

public class Case27 {

    /**
     * 双指针头尾寻找的是错误的
     * 错误解法：只有一个元素的时候，双指针交汇，无法找到合适的条件去处理元素
     */
    public static int removeElementError(int[] nums, int val) {
        int len = nums.length;
        int i = 0, j = 0;
        while (i < len) {
            while (i < len && nums[i] != val) {
                i++;
            }
            while (j < len && nums[j] == val) {
                j--;
            }

            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        return i + 1;

    }

    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // j记录的是不等于val的个数
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;

    }

    public static void main(String[] args) {
//        int[] nums={3,2,2,3};
//        int ret = removeElement(nums, 3);
//        for (int i=0; i<ret;i++ ) {
//            System.out.println(nums[i]);
//        }

        int[] nums = {3};
        int ret = removeElement(nums, 3);
        for (int i = 0; i < ret; i++) {
            System.out.print(nums[i] + "->");
        }
    }
}
