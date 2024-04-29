package leetcode;

public class Case200 {

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count += 1;
                    dfs(grid, i, j, row, col, visited);
                }
            }
        }
        return count;
    }

    // 方向数组，分别代表上、下、左、右
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    void dfs(char[][] grid, int i, int j, int row, int col, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }
        if (visited[i][j]) {
            // 已遍历过 (i, j)
            return;
        }

        // 进入节点 (i, j)
        visited[i][j] = true;
        // 递归遍历上下左右的节点
        for (int[] d : dirs) {
            int next_i = i + d[0];
            int next_j = j + d[1];
            dfs(grid, next_i, next_j, row, col, visited);
        }
        // 离开节点 (i, j)
    }

    public static void main(String[] args) {

    }

}
