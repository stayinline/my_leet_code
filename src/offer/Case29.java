package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Case29 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        int m = matrix.length; //行数
        int n = matrix[0].length; //列数

        int left = 0, right = n - 1;
        int up = 0, down = m - 1;
        while (true) {

            //向右
            for (int i = left; i <= right; i++) {
                ret.add(matrix[up][i]);
            }
            up++;
            if (up > down) break;

            // 向下
            for (int i = up; i <= down; i++) {
                ret.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;


            // 向左
            for (int i = right; i >= left; i--) {
                ret.add(matrix[down][i]);
            }
            down--;
            if (down < up) break;

            // 向上
            for (int i = down; i >= up; i--) {
                ret.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;

        }
        return ret;
    }

    public static int[] spiralOrder2(int[][] matrix) {
        int m = matrix.length; //行数
        int n = matrix[0].length; //列数
        int[] ret = new int[m * n];
        int idx = 0;

        int left = 0, right = n - 1;
        int up = 0, down = m - 1;
        while (true) {

            //向右
            for (int i = left; i <= right; i++) {
                ret[idx++] = matrix[up][i];
            }
            up++;
            if (up > down) break;

            // 向下
            for (int i = up; i <= down; i++) {
                ret[idx++] = matrix[i][right];
            }
            right--;
            if (left > right) break;


            // 向左
            for (int i = right; i >= left; i--) {
                ret[idx++] = matrix[down][i];
            }
            down--;
            if (down < up) break;

            // 向上
            for (int i = down; i >= up; i--) {
                ret[idx++] = matrix[i][left];
            }
            left++;
            if (left > right) break;

        }
        return ret;
    }


    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(spiralOrder(arr));
        System.out.println(Arrays.toString(spiralOrder2(arr)));
    }


}
