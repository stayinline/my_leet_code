package offer;

import java.util.Arrays;

public class Case17 {


    public static int[] printNumbers(int n) {
        int n9 = getN9(n);
        int[] ret = new int[n9];
        for (int i = 1; i <= n9; i++) {
            ret[i - 1] = i;
        }
        return ret;
    }

    // 计算n位数中最大的那个 ，也就是n个9的数
    public static int getN9(int n) {
        int s = 9;
        for (int i = 1; i < n; i++) {
            s = s * 10 + 9;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(2)));
    }

}
