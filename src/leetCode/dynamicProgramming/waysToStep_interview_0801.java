package leetCode.dynamicProgramming;
/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，
 * 计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 *
 * 示例2:
 *  输入：n = 5
 *  输出：13
 *
 * 提示:
 *     n范围在[1, 1000000]之间
 */
public class waysToStep_interview_0801 {
    /**
     * 执行用时：44 ms, 在所有 Java 提交中击败了13.54% 的用户
     * 内存消耗：42 MB, 在所有 Java 提交中击败了62.55% 的用户
     * 算法思路：经典dp类型题目
     * 走上第n级台阶共有三种方式
     *  一步走
     *  两步走
     *  三步走
     * @param n
     * @return
     */
    public int waysToStep(int n) {
        if(n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i <= n;i++){
            dp[i] = ( dp[i - 1] + dp[i - 2] ) % 1000000007 + dp[i - 3];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}
