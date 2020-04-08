package leetCode.array;

import java.util.ArrayList;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 *
 *
 * 示例 1:
 *
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
 *
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
 *
 */
public class rotate_interview_0107 {
    public static void main(String[] args) {

    }

    /**
     * 首先使用额外空间进行转换：很明显，旋转90°就是将第一列的变成第一行……以此类推
     * 可以使用集合保存每一列的数，然后赋值给旧数组
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int N = matrix.length;
        ArrayList<int[]> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            int[] temp = new int[N];
            count = 0;
            for (int j = N - 1; j >= 0; j--) {
                temp[count++] = matrix[j][i];
            }
            list.add(temp);
        }
    }

    /**
     * 原地：不使用额外空间
     * 原数组：
     *       1   2   3
     *       4   5   6
     *       7   8   9
     *
     * 先以主对角线（159）进行旋转
     *       1   4   7
     *       2   5   8
     *       3   6   9
     *
     * 再以每一行的中点进行翻转
     *      7   4   1
     *      8   5   2
     *      9   6   3
     *
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :39.9 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param matrix
     */
    public static void rotate02(int[][] matrix){
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
            }
        }

        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[i][n-1-j];
                matrix[i][n-1-j] = matrix[i][j] ^ matrix[i][n-1-j];
                matrix[i][j] = matrix[i][j] ^ matrix[i][n-1-j];
            }
        }

    }
}
