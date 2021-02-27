package leetCode.array;
/**
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *
 * 提示：
 *     m == matrix.length
 *     n == matrix[i].length
 *     1 <= m, n <= 1000
 *     1 <= m * n <= 10^5
 *     -10^9 <= matrix[i][j] <= 10^9
 */
public class transpose_867 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        new transpose_867().transpose(matrix);
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了64.15% 的用户
     * @param matrix
     * @return
     */
    public int[][] transpose(int[][] matrix) {
        int row = matrix[0].length,col = matrix.length;
        int[][] res = new int[row][col];
        for(int i = 0;i < row;i++){
            for (int j = 0; j < col; j++) {
                res[i][j] = matrix[j][i];
            }
        }
        return res;
    }
}
