package offer;

public class Case4 {
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int row = matrix.length, col = matrix[0].length;
            int i = 0, j = col - 1;
            while (i < row && j >= 0) {
                int num = matrix[i][j];
                if (num == target) {
                    return true;
                } else if (num > target) {
                    j--;
                } else {
                    i++;
                }
            }
            return false;
        }
    }
}
