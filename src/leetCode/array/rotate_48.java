package leetCode.array;
/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 示例 2:
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class rotate_48 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了54.08% 的用户
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int abs1 = 0;
        int abs2 = matrix.length - 1;
        int times = 0;
        while (abs1 <= abs2) {
            int p1 = abs1;
            int p2 = abs2;
            while (p1 != abs2) {
                int temp = matrix[abs1][p1];        //左上
                matrix[abs1][p1] = matrix[p2][abs1];//左上 = 左下
                matrix[p2][abs1] = matrix[abs2][p2];//左下 = 右下
                matrix[abs2][p2] = matrix[p1][abs2];//右下 = 右上
                matrix[p1][abs2] = temp;            //右上 = 左上
                p1 += 1;
                p2 -= 1;
            }
            abs1 += 1;
            abs2 -= 1;
        }
    }
}
