package leetcode;

public class Case6 {
    public static int minCount(int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            count += coins[i] / 2;
            if (coins[i] / 2 == 1) {
                count += 1;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] coins = {2, 3, 10};
        int i = minCount(coins);
        System.out.println(i);
    }
}
