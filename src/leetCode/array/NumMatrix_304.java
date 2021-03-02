package leetCode.array;
/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 *
 * 示例：
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 * 提示：
 *     你可以假设矩阵不可变。
 *     会多次调用 sumRegion 方法。
 *     你可以假设 row1 ≤ row2 且 col1 ≤ col2 。
 */
public class NumMatrix_304 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        new NumMatrix_304(matrix);
    }

    /**
     * 执行用时：16 ms, 在所有 Java 提交中击败了39.83% 的用户
     * 内存消耗：43.6 MB, 在所有 Java 提交中击败了99.17% 的用户
     */
    private int[][] sums;
    public NumMatrix_304(int[][] matrix) {
        if (matrix.length < 1) return ;
        int row = matrix.length,col = matrix[0].length;
        sums = new int[row][col];
        for (int i = 0; i < row; i++) {
            sums[i][0] = matrix[i][0];
            for (int j = 1; j < col; j++) {
                sums[i][j] = matrix[i][j] + sums[i][j - 1];
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            if(col1 == 0) res += sums[i][col2];
            else res += (sums[i][col2] - sums[i][col1 - 1]);
        }

        return res;
    }
}
