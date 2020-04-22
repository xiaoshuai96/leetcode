package leetCode.Depth_Breadth_FirstSearch;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 *     值 0 代表空单元格；
 *     值 1 代表新鲜橘子；
 *     值 2 代表腐烂的橘子。
 *
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *示例 1：
 *
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 *
 * 示例 2：
 *
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 *
 * 示例 3：
 *
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为0分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *
 *
 * 提示：
 *
 *     1 <= grid.length <= 10
 *     1 <= grid[0].length <= 10
 *     grid[i][j] 仅为 0、1 或 2
 *
 */
public class orangesRotting_994 {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int i = orangesRotting02(grid);
        System.out.println(i);
    }
    public static int orangesRotting(int[][] grid) {
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};
        int R = grid.length, C = grid[0].length;

        Queue<Integer> queue = new ArrayDeque();
        Map<Integer, Integer> depth = new HashMap();
        for (int r = 0; r < R; ++r){
            for (int c = 0; c < C; ++c){
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }

        for (int[] row: grid)
            for (int v: row)
                if (v == 1)
                    return -1;
        return ans;

    }

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了86.45% 的用户
     * 内存消耗 :39.2 MB, 在所有 Java 提交中击败了66.67%的用户
     * @param grid
     * @return
     */
    public static int orangesRotting02(int[][] grid){
        int row = grid.length,col = grid[0].length;
        Queue<int[]> queue = new ArrayDeque();
        int count = 0;//统计新鲜橘子的数量
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        int res = 0;
        while (count > 0 && !queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                int r = temp[0],c = temp[1];//(x,y)
                //上
                if (r > 0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    count--;
                    queue.add(new int[]{r-1,c});
                }
                //下
                if (r < grid.length-1 && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    count--;
                    queue.add(new int[]{r+1,c});
                }
                //左
                if (c > 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    count--;
                    queue.add(new int[]{r,c-1});
                }
                //右
                if (c < grid[0].length-1 && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    count--;
                    queue.add(new int[]{r,c+1});
                }
            }
        }
        if (count > 0) {
            return -1;
        }
        return res;
    }
}
