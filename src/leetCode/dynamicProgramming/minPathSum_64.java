package leetCode.dynamicProgramming;

/**
 *给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 */
public class minPathSum_64 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了88.89% 的用户
     * 内存消耗 :42.7 MB, 在所有 Java 提交中击败了24.85%的用户
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid){
        int cow = grid.length,col = grid[0].length;
        for(int i = 0;i < cow;i++){
            for(int j = 0;j < col;j++){
                if(i == 0 && j == 0){
                    continue;
                }else if(i == 0){
                    grid[i][j] += grid[i][j-1];
                }else if(j == 0){
                    grid[i][j] += grid[i-1][j];
                }else{
                    grid[i][j] += Math.min(grid[i][j-1],grid[i-1][j]);
                }
            }
        }
        return grid[cow-1][col-1];
    }

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了88.89% 的用户
     * 内存消耗 :42.8 MB, 在所有 Java 提交中击败了24.23%的用户
     * @param grid
     * @return
     */
    public static int minPathSum02(int[][] grid){
        int cow = grid.length,col = grid[0].length;
        //初始化第一行
        for(int i = 1;i < col;i++) grid[0][i] += grid[0][i-1];
        //初始化第一列
        for(int j = 1;j < cow;j++) grid[j][0] += grid[j-1][0];
        for (int i = 1; i < cow; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] += Math.min(grid[i][j-1],grid[i-1][j]);
            }
        }
        return grid[cow-1][col-1];
    }
}
