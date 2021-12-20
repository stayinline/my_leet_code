package offer;

public class Case53_2 {

    /**
     * 有问题，[0]的预期结果是1
     *
     * @param nums
     * @return
     */
    public static int missingNumber1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return -1;
    }

    public static int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,5};
        System.out.println(missingNumber(nums));
    }
}
