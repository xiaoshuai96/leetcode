package leetCode.binarySearch;
/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *     每行的元素从左到右升序排列。
 *     每列的元素从上到下升序排列。
 *
 * 示例 1：
 * 输入：matrix = [  [1,4,7,11,15],
 *                  [2,5,8,12,19],
 *                  [3,6,9,16,22],
 *                  [10,13,14,17,24],
 *                  [18,21,23,26,30]
 *                ], target = 5
 * 输出：true
 *
 * 示例 2：
 * 输入：matrix = [  [1,4,7,11,15],
 *                  [2,5,8,12,19],
 *                  [3,6,9,16,22],
 *                  [10,13,14,17,24],
 *                  [18,21,23,26,30]
 *              ], target = 20
 * 输出：false
 *
 *
 *
 * 提示：
 *
 *     m == matrix.length
 *     n == matrix[i].length
 *     1 <= n, m <= 300
 *     -10^9 <= matrix[i][j] <= 10^9
 *     每行的所有元素从左到右升序排列
 *     每列的所有元素从上到下升序排列
 *     -10^9 <= target <= 10^9
 */
public class searchMatrix_240 {
    /**
     * 从一开始将位置锁定在矩形数组的左下角，i表示最后一行的位置，j表示第0列的位置
     * 如果matrix[i][j] > target，这说明i这一行的元素中一定不存在target（因为一行的数字都是按照从左到右、从小到大的顺序排列的），向上移动
     * 如果matrix[i][j] < target,这说明这一列的元素中一定是不存在target（因为一列的数字都是按照从上到下，从小到大的顺序排列的），向上移动
     * 如果matrix[i][j] = target，说明目标元素存在，直接返回true即可
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1,j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
}
