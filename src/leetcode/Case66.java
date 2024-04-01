package leetcode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Case66 {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0) {
            return digits;
        }

        List<Integer> list = new ArrayList<>();

        int sum = digits[len - 1] + 1;
        int flag = sum / 10;
        list.add(sum % 10);
        for (int i = len - 2; i >= 0; i--) {
            int tmp = digits[i] + flag;
            list.add(tmp % 10);
            flag = tmp / 10;
        }


        if (flag == 1) {
            list.add(flag);

        }
        Collections.reverse(list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }

    public int[] plusOneNiubi(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;

            if (digits[i] != 0)
                // 这里如果不等于0，说明加一后小于10 ，那么，停下即可，不用再累加了
                return digits;
        }
        // 出来了，一定说明有溢出，那么第一个元素补一个1
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }


    public static void main(String[] args) {
        int[] arr = {9};
        int[] ints = plusOne(arr);
        System.out.println(Arrays.toString(ints));
        arr=new int[2];

    }
}
