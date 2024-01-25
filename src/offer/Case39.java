package offer;

public class Case39 {

    public static int majorityElement(int[] nums) {
        int temp = nums[0]; // 数组第一个元素当做开始
        int sum = 0; //票数
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == temp) {
                sum += 1;
            } else {
                sum -= 1;
            }
            if (sum == 0) {
                temp = nums[i + 1];
            }
            i++;
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int ret = majorityElement(arr);
        System.out.println(ret);
    }

}
