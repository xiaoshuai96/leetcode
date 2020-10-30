package leetCode.Depth_Breadth_FirstSearch;


/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，
 * 但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
 * 格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 */
public class islandPerimeter_463 {
    public static void main(String[] args) {

    }
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了56.99% 的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了62.52% 的用户
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid){
        int res = 0;
        int n = grid.length, m = grid[0].length;
        for(int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                //找到局部岛屿之后，判断它四周是否有和它关联的岛屿存在
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0;k < 4;++k){
                        //横坐标
                        int tx = i + dx[k];
                        //纵坐标
                        int ty = j + dy[k];
                        /**
                         * 1.如果横坐标小于0，这意味着该小岛屿的左边是不存在岛屿的；
                         * 2.如果横坐标大于等于最右边的“墙”，那么它的右边是不存在岛屿的；
                         * 3.如果纵坐标小于0，它的上面不存在岛屿；
                         * 4.如果纵坐标大于等于最下面的“墙”，它的下面是不存在岛屿的；
                         * 5.如果这个位置的值为0，表示它不是陆地；
                         */
                        if (tx < 0 || tx >= n || ty < 0
                                || ty >= m || grid[tx][ty] == 0) {
                            cnt += 1;
                        }
                    }
                    res += cnt;
                }
            }
        }
        return res;
    }

    /**
     * 执行用时：10 ms, 在所有 Java 提交中击败了48.91% 的用户
     * 内存消耗：40.4 MB, 在所有 Java 提交中击败了5.05% 的用户
     * @param grid
     * @return
     */
    public int islandPerimeter02(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    /**
     * 深度优先搜索
     * @param grid
     * @param r
     * @param c
     * @return
     */
    private int dfs(int[][] grid, int r, int c) {
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return 1;
        }
        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        //将遍历过的岛屿进行标识，否则最后会造成死循环
        grid[r][c] = 2;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }
}
