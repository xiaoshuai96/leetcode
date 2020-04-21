package leetCode.depthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 * 输入:
 *  1 1 1 1 0
 *  1 1 0 1 0
 *  1 1 0 0 0
 *  0 0 0 0 0
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 *  1 1 0 0 0
 *  1 1 0 0 0
 *  0 0 1 0 0
 *  0 0 0 1 1
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 */
public class numIslands_200 {
    public static void main(String[] args) {
        int i = numIslands(new char[][]{{'1', '1', '1', '1', '0'},
                                        {'1', '1', '0', '1', '0'},
                                        {'1', '1', '1', '0', '0'},
                                        {'0', '0', '0', '0', '0'}});
        System.out.println(i);
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :42.5 MB, 在所有 Java 提交中击败了6.25%的用户
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid){
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        int row = grid.length,col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    /**
     * 找出给的一个块陆地周围所有挨着的陆地，并将它们置为‘0’
     * @param grid
     * @param r
     * @param c
     */
    private static void dfs(char[][] grid, int r, int c) {
        int row = grid.length,col = grid[0].length;
        if (r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid,r-1,c);//up
        dfs(grid,r+1,c);//down
        dfs(grid,r,c-1);//left
        dfs(grid,r,c+1);//right
    }

    /**
     * 执行用时 :7 ms, 在所有 Java 提交中击败了16.37% 的用户
     * 内存消耗 :42.2 MB, 在所有 Java 提交中击败了6.25%的用户
     * @param grid
     * @return
     */
    public static int numIslands02(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }

}

