package leetcode;

public class Case169 {

    public int majorityElement(int[] nums) {

        int ans = -1, v = 0;
        for (int num : nums) {
            if (v == 0) {
                ans = num;
            }
            if (ans == num) {
                v++;
            } else {
                v--;
            }
        }
        return ans;
    }
}
