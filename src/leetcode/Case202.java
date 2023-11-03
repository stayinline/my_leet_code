package leetcode;

public class Case202 {

    public boolean isHappy(int n) {
        int fast = n, slow = n;
        /**
         * 用快慢指针的思想去追逐，只要fast==slow
         * 说明int类型溢出了，也就是fast追上了slow
         * 只要追上了，那就出循环，
         * 最后判断是不是在1这个点追上的即可
         */
        do {
            fast = sum(fast);
            fast = sum(fast);
            slow = sum(slow);
        }
        while (fast != slow);
        return slow == 1;
    }


    // 栈溢出
    public boolean isHappyError(int n) {
        while (true) {
            long tmp = sum(n);
            if (n == 1) {
                return true;
            } else if (Integer.MAX_VALUE < tmp) {
                return false;
            }
            n = (int) sum(n);

        }

    }

    public int sum(int n) {
        int ans = 0;
        for (; n != 0; n = n / 10) {
            int a = n % 10;
            ans += a * a;
        }
        return ans;
    }
}
