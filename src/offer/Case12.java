package offer;

public class Case12 {

    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 采用深度优先法，尝试遍历每一个bord[i][j]是否符合预期，
     * 只要有任意一个符合就可以
     *
     * @param board 矩阵
     * @param words 目标字符串
     * @param i     遍历矩阵的行对应的索引
     * @param j     遍历矩阵的列对应的索引
     * @param k     遍历目标字符串words的索引
     * @return
     */
    static boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        // 处理边界值和不符合预期的值
        if (i >= board.length
                || i < 0
                || j >= board[0].length
                || j < 0
                || board[i][j] != words[k]) {
            return false;
        }

        // 目标字符串遍历完了，说明全都匹配上了，返回true
        if (k == words.length - 1) {
            return true;
        }
        /* 执行到这里，说明前面的两个if条件都没有执行，
         * 也就是说 board[i][j]== words[k] ，即当前这个值是有效的，
         * 为了后续其他的节点遍历时，不要再次占用，先标记成 '\0'
         */
        board[i][j] = '\0';
        boolean res = dfs(board, words, i + 1, j, k + 1) /* 向下遍历 */
                || dfs(board, words, i - 1, j, k + 1)    /* 向上遍历 */
                || dfs(board, words, i, j + 1, k + 1)    /* 向右遍历 */
                || dfs(board, words, i, j - 1, k + 1);   /* 向左遍历 */

        /* 执行到这里，所有的当前的board[i][j]都遍历完了，
         *为了后续其他的节点遍历，这里需要恢复 board[i][j]
         */
        board[i][j] = words[k];
        return res;
    }

    public static void main(String[] args) {
        char[][] bord = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCE";
        boolean exist = exist(bord, word);
        System.out.println(exist);
    }

}
