package dp;

public class Case70 {

    public int climbStairs1(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    public int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] memory = new int[n + 1];
        return climbStairsHelper(n - 1, memory) + climbStairsHelper(n - 2, memory);
    }

    public static int climbStairsHelper(int n, int[] memory) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        memory[n] = climbStairsHelper(n - 1, memory) + climbStairsHelper(n - 2, memory);
        return memory[n];
    }


    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
