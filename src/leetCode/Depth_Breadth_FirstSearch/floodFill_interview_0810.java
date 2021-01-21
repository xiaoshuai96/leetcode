package leetCode.Depth_Breadth_FirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。
 * 需要填充的新颜色为 newColor 。
 * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 *
 *
 * 示例：
 * 输入：
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出：[[2,2,2],[2,2,0],[2,0,1]]
 * 解释:
 * 初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
 * 初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
 * 注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
 *
 *
 * 提示：
 *     image 和 image[0] 的长度均在范围 [1, 50] 内。
 *     初始坐标点 (sr,sc) 满足 0 <= sr < image.length 和 0 <= sc < image[0].length 。
 *     image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535] 内。
 */
public class floodFill_interview_0810 {
    public static void main(String[] args) {
        int[][] image = {{0,0,0},{0,1,1}};
        new floodFill_interview_0810().floodFill(image,1,1,1);
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了10.75% 的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了37.96% 的用户
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length,col = image[0].length;
        int target = image[sr][sc];
        if (target == newColor) return image;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                image[poll[0]][poll[1]] = newColor;
                //上
                if (poll[1] - 1 >= 0 && image[poll[0]][poll[1] - 1] == target) {
                    queue.add(new int[]{poll[0],poll[1] - 1});
                }
                //下
                if (poll[1] + 1 < col && image[poll[0]][poll[1] + 1] == target) {
                    queue.add(new int[]{poll[0],poll[1] + 1});
                }
                //左
                if (poll[0] - 1 >= 0 && image[poll[0] - 1][poll[1]] == target) {
                    queue.add(new int[]{poll[0] - 1,poll[1]});
                }
                //右
                if (poll[0] + 1 < row && image[poll[0] + 1][poll[1]] == target) {
                    queue.add(new int[]{poll[0] + 1,poll[1]});
                }
            }
        }
        return image;
    }
}
