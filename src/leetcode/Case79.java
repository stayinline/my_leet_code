package leetcode;

public class Case79 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row == 0) {
            return false;
        }
        int col = board[0].length;
        boolean[][] visit = new boolean[row][col];
        // 遍历每一个board[i][j]
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean ret = checkArray(board, i, j, visit, word, 0, row, col);
                if (ret) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param board
     * @param i         横坐标
     * @param j         纵坐标
     * @param visit     visit[i][j]表示：是否使用过当前board[i][j]的字母
     * @param word
     * @param idxOfWord 目前凑到Word的哪一个下标了
     * @param row       board的行下标阈值
     * @param col       board的列下标阈值
     * @return
     */
    private boolean checkArray(char[][] board, int i, int j, boolean[][] visit, String word, int idxOfWord, int row, int col) {
        if (board[i][j] != word.charAt(idxOfWord)) {
            // 当前不等，一定是不存在
            return false;
        } else if (idxOfWord == word.length() - 1) {
            // word结束，一定是存在
            return true;
        }// 越界问题不用考虑，上一个调用已经处理了

        visit[i][j] = true;
        boolean ret = false;

        // 基于[i][j,]需要遍历的上下左右四个坐标
        int[][] chowes = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : chowes) {
            int curi = i + dir[0], curj = j + dir[1];
            if (curi >= 0 && curi < row && curj >= 0 && curj < col) {
                if (!visit[curi][curj]) {
                    boolean curRet = checkArray(board, curi, curj, visit, word, idxOfWord + 1, row, col);
                    if (curRet) {
                        ret = true;
                        break;
                    }
                }

            }
        }
        // 回溯法之撤销上一步的操作
        visit[i][j] = false;
        return ret;
    }

    static class Solution {
        public boolean exist(char[][] board, String word) {
            int row = board.length;
            int col = board[0].length;

            boolean[][] visit = new boolean[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    boolean ret = find(board, i, j, visit, word, 0, row, col);
                    if (ret) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean find(char[][] board, int i, int j, boolean[][] visit, String word, int idxOfWord, int row, int col) {

            if (word.charAt(idxOfWord) != board[i][j]) {
                return false;
            } else if (idxOfWord == word.length() - 1) {
                return true;
            }

            visit[i][j] = true;

            boolean result = false;

            int[][] chowes = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : chowes) {
                int next_i = dir[0] + i;
                int next_j = dir[1] + j;
                if (next_i >= 0 && next_i < row && next_j >= 0 && next_j < col) {
                    if (!visit[next_i][next_j]) {
                        boolean nextResult = find(board, next_i, next_j, visit, word, idxOfWord + 1, row, col);
                        if (nextResult) {
                            result = true;
                            break;
                        }
                    }
                }
            }

            visit[i][i] = false;
            return result;

        }
    }

    public static void main(String[] args) {

        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        boolean exist = new Case79.Solution().exist(board, word);
        System.out.println(exist);
    }

}
