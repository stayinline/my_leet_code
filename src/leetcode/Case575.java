package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Case575 {

    public static int distributeCandies(int[] candyType) {
        int n = candyType.length;

        Set<Integer> set = new HashSet<>();
        for (int c : candyType) {
            set.add(c);
        }
        int total = set.size();
        if (total <= n / 2) {
            return total;
        } else {
            return n / 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3};
        System.out.println(distributeCandies(arr));

        int[] arr2 = {1, 1, 2, 3};
        System.out.println(distributeCandies(arr2));

        int[] arr3 = {1, 1, 1, 1};
        System.out.println(distributeCandies(arr3));
    }
}
