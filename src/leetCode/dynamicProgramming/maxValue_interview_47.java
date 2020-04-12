package leetCode.dynamicProgramming;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
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
 *
 *     0 < grid.length <= 200
 *     0 < grid[0].length <= 200
 *
 *
 */
public class maxValue_interview_47 {
    public static void main(String[] args) {
        int i = maxValue02(new int[][]{{1, 2, 5}, {3, 2, 1}});
        System.out.println(i);
    }

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了85.51% 的用户
     * 内存消耗 :42.2 MB, 在所有 Java 提交中击败了100.00%的用户
     *
     * 很明显，在本来时间复杂度很高的情况下，每次还要冗余的判断（0,0）只需要判断一次
     * @param grid
     * @return
     */
    public static int maxValue(int[][] grid){
        int cow = grid.length;
        int col = grid[0].length;
        for(int i = 0;i < cow; i++){
            for(int j = 0;j < col; j++){
                if(i == 0 && j == 0) continue;
                else if (i == 0) {
                    grid[i][j] += grid[i][j-1];
                }else if (j == 0){
                    grid[i][j] += grid[i-1][j];
                }else {
                    grid[i][j] += Math.max(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[cow-1][col-1];
    }

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了85.51% 的用户
     * 内存消耗 :42.7 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param grid
     * @return
     */
    public static int maxValue02(int[][] grid) {
        int cow = grid.length;
        int col = grid[0].length;
        for (int i = 1; i < col; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for(int i = 1;i < cow; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0){
                    grid[i][j] += grid[i-1][j];
                }else {
                    grid[i][j] += Math.max(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[cow-1][col-1];
    }
}
