package leetcode;

public class Case29 {
    public static int divide(int dividend, int divisor) {
        boolean flag = dividend > 0 ^ divisor > 0;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long res = 0;
        int digit = 0;
        while (a >= b << digit) {
            digit++;
        }
        while (a >= b) {
            if (a >= b << digit) {
                a -= b << digit;
                res += (long) 1 << digit;
            }
            digit--;
        }
        res = flag ? -res : res;
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;
    }

    public static void main(String[] args) {

    }
}
