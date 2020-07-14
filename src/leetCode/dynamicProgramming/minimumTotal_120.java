package leetCode.dynamicProgramming;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class minimumTotal_120 {
    public static void main(String[] args) {

    }

    /**
     * 递归版本：超时
     * @param triangle
     * @return
     */
    public int minimumTotal01(List<List<Integer>> triangle) {
        return  dfs01(triangle, 0, 0);
    }

    private int dfs01(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        return Math.min(dfs01(triangle, i + 1, j),
                dfs01(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }


    Integer[][] memo;
    public int minimumTotal02(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return  dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        return memo[i][j] = Math.min(dfs(triangle, i + 1, j),
                dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了42.68% 的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了8.70% 的用户
     * @param triangle
     * @return
     */
    public int minimumTotal03(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
        int[][] dp = new int[n + 1][n + 1];
        // 从三角形的最后一行开始递推。
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了96.02% 的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了8.70% 的用户
     * @param triangle
     * @return
     */
    public static int minimumTotal04(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    /**
     * 思路错误
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle){
        int sum = 0,index = 0;
        for (int i = 0;i < triangle.size();i++){
            if (triangle.get(i).size() == 1) {
                sum += triangle.get(i).get(0);
                continue;
            }
            int left = triangle.get(i).get(index);
            int right = triangle.get(i).get(index+1);
            if (left < right) {
                sum += left;
            } else {
                sum += right;
                index += 1;
            }
        }
        return sum;
    }
}
