package leetCode.array;

/**
 * 请你实现一个类 SubrectangleQueries ，它的构造函数的参数是一个 rows x cols 的矩形（这里用整数矩阵表示），
 * 并支持以下两种操作：
 *
 * 1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 *
 * 用 newValue 更新以 (row1,col1) 为左上角且以 (row2,col2) 为右下角的子矩形。
 * 2. getValue(int row, int col)
 *
 * 返回矩形中坐标 (row,col) 的当前值。
 *
 * 示例 1：
 *
 * 输入：
 * ["SubrectangleQueries","getValue","updateSubrectangle","getValue",
 * "getValue","updateSubrectangle","getValue","getValue"]
 * [[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],
 * [3,0,3,2,10],[3,1],[0,2]]
 * 输出：
 * [null,1,null,5,5,null,10,5]
 *
 * 示例 2：
 *
 * 输入：
 * ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue",
 * "updateSubrectangle","getValue"]
 * [[[[1,1,1],[2,2,2],[3,3,3]]],[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2]]
 * 输出：
 * [null,1,null,100,100,null,20]
 * 解释：
 * SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,1,1],
 * [2,2,2],[3,3,3]]);
 * subrectangleQueries.getValue(0, 0); // 返回 1
 * subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
 * subrectangleQueries.getValue(0, 0); // 返回 100
 * subrectangleQueries.getValue(2, 2); // 返回 100
 * subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
 * subrectangleQueries.getValue(2, 2); // 返回 20
 * 
 * 提示：
 *
 *      最多有 500 次updateSubrectangle 和 getValue 操作。
 *      1 <= rows, cols <= 100
 *      rows == rectangle.length
 *      cols == rectangle[i].length
 *      0 <= row1 <= row2 < rows
 *      0 <= col1 <= col2 < cols
 *      1 <= newValue, rectangle[i][j] <= 10^9
 *      0 <= row < rows
 *      0 <= col < cols
 */
public class SubrectangleQueries_1476 {
    /**
     * 执行用时：31 ms, 在所有 Java 提交中击败了73.84% 的用户
     * 内存消耗：42.1 MB, 在所有 Java 提交中击败了100.00% 的用户
     */
    int[][] temp = null;
    public static void main(String[] args) {

    }
    public SubrectangleQueries_1476(int[][] rectangle) {
        temp = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for(int j = col1;j <= col2; j++){
                temp[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return temp[row][col];
    }
}