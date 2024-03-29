package leetCode.dynamicProgramming;
/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
 * 并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * 提示：
 *     0 < grid.length <= 200
 *     0 < grid[0].length <= 200
 */
public class maxValue_offer_47 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2,5},{3,2,1}};
        new maxValue_offer_47().maxValue(grid);
    }
    public int maxValue(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        //init first row
        for(int i = 1;i < col; ++i){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        //init first col
        for(int j = 1;j < row; ++j){
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }
        for(int i = 1;i < row; ++i){
            for(int j = 1;j < col; ++j){
                dp[i][j] = Math.max(dp[i][j - 1] + grid[i][j],dp[i - 1][j] + grid[i][j]);
            }
        }
        return dp[row - 1][col - 1];
    }
}
