package leetcode;

import java.util.Arrays;

public class Case73 {

    // 注意审题：是将0所在的行和列全部设置为0，而不是将0的上下左右设置为0

//    public static void setZeroesError(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int[] rows = new int[m];
//        int[] cols = new int[n];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = i; j < n; j++) {
//                if (matrix[i][j] == 0 && rows[i] == 0 && cols[j] == 0) {
//                    rows[i] = 1;
//                    cols[j] = 1;
//                    for (int a = 0; a < m; a++) {
//                        matrix[a][j] = 0;
//                    }
//                    for (int a = 0; a < n; a++) {
//                        matrix[i][a] = 0;
//                    }
//                }
//            }
//        }
//    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] arr = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};
        setZeroes(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
