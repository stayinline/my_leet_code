package offer;

public class Case56_1 {
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums) {
            // 1. 遍历异或
            n ^= num;
        }
        while ((n & m) == 0) {
            // 2. 循环左移，计算 m，找到 n 中那个为1的比特位所代表的数字
            m <<= 1;
        }
        // 3. 遍历 nums 分组，由每一个元素与m异或，会分为两部分
        // 这两部分就变成了: 【k个数，只有一个数字出现了一次，找到这个数字】的子问题
        for (int num : nums) {
            // 4. 当 num & m != 0}
            if ((num & m) != 0) {
                x ^= num;
            } else {
                // 4. 当 num & m == 0}
                y ^= num;
            }
        }
        // 5. 返回出现一次的数字
        return new int[]{x, y};
    }

}


