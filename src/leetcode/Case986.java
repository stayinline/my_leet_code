package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Case986 {


    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> ans = new ArrayList<>();

        for (int i = 0, j = 0; i < firstList.length && j < secondList.length; ) {
            // 交集需要取两个数组左边界较大的，以及右边界较小的
            int l = Math.max(firstList[i][0], secondList[j][0]);
            int r = Math.min(firstList[i][1], secondList[j][1]);
            // 有交集，说明符合需要，直接添加到结果集
            if (l <= r) {
                ans.add(new int[]{l, r});
            }

            // 判断是谁的边界范围更大，更大的一定是包含另一个的，所以移动较小的那一个的指针
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }


    public static void main(String[] args) {
        int[][] first = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] second = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        System.out.println(Arrays.deepToString(intervalIntersection(first, second)));
    }
}
