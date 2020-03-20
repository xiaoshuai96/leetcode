package leetCode.dynamicProgramming;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class coinChange_322 {
    public static void main(String[] args) {
        int i = coinChange02(new int[]{1, 3, 5}, 11);
        System.out.println(i);
    }

    /**
     * 执行用时 :25 ms, 在所有 Java 提交中击败了20.60% 的用户
     * 内存消耗 :40.8 MB, 在所有 Java 提交中击败了5.01%的用户
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange01(int[] coins, int amount) {
        //记录表
        int[] f = new int[amount + 1];
        //f(0) = 0
        f[0] = 0;
        for(int i = 1; i <= amount; i++){
            int cost = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0){
                    if(f[i-coins[j]] != Integer.MAX_VALUE)
                        cost = Math.min(cost, f[i - coins[j]] + 1);
                }
            }
            f[i] = cost;
        }
        return  f[amount] == Integer.MAX_VALUE? -1 : f[amount];
    }

    /**
     * 执行用时 :16 ms, 在所有 Java 提交中击败了49.38% 的用户
     * 内存消耗 :40.7 MB, 在所有 Java 提交中击败了5.01%的用户
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange02(int[] coins,int amount){
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
