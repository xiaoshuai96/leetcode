package leetCode.binarySearch;
/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 *
 *
 * 限制：
 *      0 <= n <= 1000
 *      0 <= m <= 1000
 */
public class findNumberIn2DArray_offer_04 {
    /**
     * 暴力法，时间复杂度O(n^2)
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0) return false;
        int col = matrix[0].length;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(target == matrix[i][j]) return true;
            }
        }
        return false;
    }

    /**
     * 从一开始将位置锁定在矩形数组的左下角，i表示最后一行的位置，j表示第0列的位置
     * 如果matrix[i][j] > target，这说明i这一行的元素中一定不存在target（因为一行的数字都是按照从左到右、从小到大的顺序排列的），向上移动
     * 如果matrix[i][j] < target,这说明这一列的元素中一定是不存在target（因为一列的数字都是按照从上到下，从小到大的顺序排列的），向上移动
     * 如果matrix[i][j] = target，说明目标元素存在，直接返回true即可
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray02(int[][] matrix, int target) {
        int i = matrix.length - 1,j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;

    }
}
