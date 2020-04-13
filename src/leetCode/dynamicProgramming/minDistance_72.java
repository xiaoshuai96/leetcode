package leetCode.dynamicProgramming;

/**
 *  给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 *     插入一个字符
 *     删除一个字符
 *     替换一个字符
 *
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 */
public class minDistance_72 {
    public static void main(String[] args) {

    }
    public static int minDistance(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        // 有一个字符串为空串
        if (n * m == 0)
            return n + m;
        // DP 数组
        int [][] D = new int[n + 1][m + 1];
        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                    left_down += 1;
                D[i][j] = Math.min(left, Math.min(down, left_down));

            }
        }
        return D[n][m];
    }

    /**
     * 执行用时 :6 ms, 在所有 Java 提交中击败了92.65% 的用户
     * 内存消耗 :40 MB, 在所有 Java 提交中击败了5.26%的用户
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance02(String word1, String word2){
        int row = word1.length();
        int col = word2.length();
        int[][] dp = new int[row+1][col+1];
        if (row * col == 0) return row + col;//有空串存在
        //初始化最左边的列和最上边的行
        for (int i = 1;i <= row ; i++) dp[i][0] = i;
        for (int j = 1;j <= col ; j++) dp[0][j] = j;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[row][col];
    }
}
