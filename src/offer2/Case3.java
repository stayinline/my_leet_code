package offer2;

import java.util.Arrays;

public class Case3 {

    public static int[] countBits(int n) {
        int[] ret = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ret[i] = count1OfBinary(i);
        }
        return ret;
    }

    public static int count1OfBinary(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
        System.out.println(count1OfBinary(2));
        System.out.println(count1OfBinary(3));
    }
}
