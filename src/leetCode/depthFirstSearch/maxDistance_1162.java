package leetCode.depthFirstSearch;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。
 * 其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？
 * 请返回该海洋区域到离它最近的陆地区域的距离。
 *
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：
 * (x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 * 示例 1：
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 *
 * 示例 2：
 *
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *
 * 提示：
 *
 *     1 <= grid.length == grid[0].length <= 100
 *     grid[i][j] 不是 0 就是 1
 *
 */
public class maxDistance_1162 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0,0,0,0},
                                   {0,0,1,0,0},
                                   {0,0,0,0,0},
                                   {0,0,0,0,1},
                                   {1,0,0,0,0}};
        int i = maxDistance(grid);
    }

    /**
     * 执行用时 :16 ms, 在所有 Java 提交中击败了89.75% 的用户
     * 内存消耗 :42.2 MB, 在所有 Java 提交中击败了99.00%的用户
     * @param grid
     * @return
     */
    public static int maxDistance(int[][] grid) {
        int N = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();
        // 将所有的陆地格子加入队列
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        // 如果我们的地图上只有陆地或者海洋，请返回 -1。
        if (queue.isEmpty() || queue.size() == N * N) {
            return -1;
        }

        int distance = -1;
        while (!queue.isEmpty()) {
            distance++;
            int n = queue.size();
            // 这里一口气取出 n 个结点，以实现层序遍历
            for (int i = 0; i < n; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                // 遍历上方单元格
                if (r-1 >= 0 && grid[r-1][c] == 0) {
                    grid[r-1][c] = 2;
                    queue.add(new int[]{r-1, c});
                }
                // 遍历下方单元格
                if (r+1 < N && grid[r+1][c] == 0) {
                    grid[r+1][c] = 2;
                    queue.add(new int[]{r+1, c});
                }
                // 遍历左边单元格
                if (c-1 >= 0 && grid[r][c-1] == 0) {
                    grid[r][c-1] = 2;
                    queue.add(new int[]{r, c-1});
                }
                // 遍历右边单元格
                if (c+1 < N && grid[r][c+1] == 0) {
                    grid[r][c+1] = 2;
                    queue.add(new int[]{r, c+1});
                }
            }
        }

        return distance;
    }
}
