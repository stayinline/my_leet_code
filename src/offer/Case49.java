package offer;

public class Case49 {


        /**
         * 动态规划
         *
         * @param n
         * @return
         */
        public static int nthUglyNumber(int n) {
            int a = 0, b = 0, c = 0;
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
                dp[i] = Math.min(Math.min(n2, n3), n5);
                if (dp[i] == n2) a++;
                if (dp[i] == n3) b++;
                if (dp[i] == n5) c++;
            }
            return dp[n - 1];
        }



    /**
     * 暴力法
     *
     * @param n
     * @return
     */
    public static int nthUglyNumber1(int n) {
        for (int i = 1; n > 0; i++) {
            if (isUgly(i)) n--;
            if (n == 0) return i;
        }
        return -1;
    }

    public static boolean isUgly(int n) {
        // 处理小于0的
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int a : factors) {
            while (n % a == 0) {
                n /= a;
            }
        }
        // 1不会进循环，直接在这里判断即可
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
