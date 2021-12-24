package offer;

public class Case47 {

    class Solution {
        /**
         * 递推公式 f(i,j)=max[f(i,j−1),f(i−1,j)]+grid(i,j)
         *
         * @param grid
         * @return
         */
        public int maxValue(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            for (int j = 1; j < n; j++) {   // 初始化第一行
                grid[0][j] += grid[0][j - 1];
            }
            for (int i = 1; i < m; i++) {   // 初始化第一列
                grid[i][0] += grid[i - 1][0];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
            return grid[m - 1][n - 1];
        }
    }


    public static int maxValue(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < col; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][col - 1];
    }


    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};

        System.out.println(maxValue(grid));
    }

}
