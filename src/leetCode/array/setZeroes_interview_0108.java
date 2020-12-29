package leetCode.array;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * 示例 1：
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 示例 2：
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */
public class setZeroes_interview_0108 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},
                          {5,0,5,2},
                          {8,9,2,0},
                          {5,7,2,1}
        };
        new setZeroes_interview_0108().setZeroes(matrix);
        int row = matrix.length,col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了44.20% 的用户
     * 内存消耗：39.9 MB, 在所有 Java 提交中击败了81.27% 的用户
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        Deque<int[]> queue = new LinkedList<>();
        int row = matrix.length,col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.addLast(new int[]{i,j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] tmp = queue.pollFirst();
            int x = tmp[0],y = tmp[1];
            //up
            while (y - 1 >= 0) {
                matrix[x][y - 1] = 0;
                --y;
            }
            x = tmp[0];y = tmp[1];
            //down
            while (y + 1 < col) {
                matrix[x][y + 1] = 0;
                ++y;
            }
            x = tmp[0];y = tmp[1];
            //left
            while (x - 1 >= 0) {
                matrix[x - 1][y] = 0;
                --x;
            }
            x = tmp[0];y = tmp[1];
            //right
            while (x + 1 < row) {
                matrix[x + 1][y] = 0;
                ++x;
            }
        }
    }
}
