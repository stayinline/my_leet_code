package dp;

public class Case509 {

    public int fib1(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }


    /**
     * 自顶向下的备忘录(剪枝)解法
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n == 1 || n == 0) {
            return n;
        }

        //int[] memory = new int[n ];
        // 错误原因，memory[i]记录的是F(i),数组下标是从[0,n-1]，所以备忘录需要多初始化一个
        int[] memory = new int[n + 1];
        return fib2Helper(memory, n);
    }

    public int fib2Helper(int[] memory, int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        memory[n] = fib2Helper(memory, n - 1) + fib2Helper(memory, n - 2);
        return memory[n];
    }

    public int fib3(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fib4(int n) {
        int a = 0, b = 1, c = a + b;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
