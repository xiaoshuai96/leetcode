package leetCode.array;
/**
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 *
 * 示例  1：
 * 输入：mat = [[1,2,3],
 *             [4,5,6],
 *             [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 *
 * 示例  2：
 * 输入：mat = [[1,1,1,1],
 *             [1,1,1,1],
 *             [1,1,1,1],
 *             [1,1,1,1]]
 * 输出：8
 *
 * 示例 3：
 * 输入：mat = [[5]]
 * 输出：5
 *
 * 提示：
 *     n == mat.length == mat[i].length
 *     1 <= n <= 100
 *     1 <= mat[i][j] <= 100
 */
public class diagonalSum_1572 {
    public static void main(String[] args) {
        int[][] mat = {{1,1,1,1},
                       {1,1,1,1},
                       {1,1,1,1},
                       {1,1,1,1}};
        int i = new diagonalSum_1572().diagonalSum(mat);
        System.out.println(i);
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了59.92% 的用户
     * @param mat
     * @return
     */
    public int diagonalSum(int[][] mat) {
        int res = 0;
        int len = mat.length;
        for (int i = 0; i < len; i++) {
            res += mat[i][i];
        }
        for (int i = 0, j = len - 1; i < len && j >= 0; i++, j--) {
            res += mat[i][j];
        }
        return len % 2 == 1 ? res - mat[len / 2][len / 2] : res;
    }
}
