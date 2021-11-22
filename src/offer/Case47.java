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

}
