package offer;

public class Case13 {

    static class Solution {
        int m, n, k;
        boolean[][] visited; // 记录哪些i、j被访问过了

        public int movingCount(int m, int n, int k) {
            this.m = m;
            this.n = n;
            this.k = k;
            this.visited = new boolean[m][n];
            return dfs(0, 0, 0, 0);
        }

        /**
         * @param i  行索引
         * @param j  列索引
         * @param si
         * @param sj
         * @return
         */
        public int dfs(int i, int j, int si, int sj) {
            if (i >= m || j >= n || k < si + sj || visited[i][j]) {
                return 0;
            }
            visited[i][j] = true;
            return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj)
                    + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Case13.Solution().movingCount(2, 3, 1));
    }
}
