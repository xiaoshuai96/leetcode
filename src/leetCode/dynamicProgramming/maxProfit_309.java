package leetCode.dynamicProgramming;
/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *     你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *     卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class maxProfit_309 {
    /**
     * 0 的转移
     *
     * 昨天 	    今天 	分析是否可以转移，可以转移的情况下今天的操作
     * 0 	    0 	    可以转移，今天什么都不做。
     * 0 	    1 	    可以转移，今天买入股票。
     * 0 	    2 	    不可以转移，不持股的情况下，不能卖出股票。
     *
     * 1 的转移
     *
     * 昨天 	    今天 	分析是否可以转移，可以转移的情况下今天的操作
     * 1 	    0 	    不可以转移，根据题意，只能转移到 222。
     * 1 	    1 	    可以转移，今天什么都不操作。
     * 1 	    2 	    根据题意可以转移。
     *
     * 2 的转移
     *
     * 昨天 	    今天 	分析是否可以转移，可以转移的情况下今天的操作
     * 2 	    0 	    可以转移，根据题意，今天就是冷冻期，什么都不能操作，进入状态 000。
     * 2 	    1	    不可以转移，根据题意，昨天刚刚卖出股票，今天不能执行买入操作。
     * 2 	    2 	    不可以转移，不持股的情况下，不能卖出股票。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[][] dp = new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        //
        /**
         * dp[i][0]: 手上不持有股票，并且今天不是由于卖出股票而不持股，我们拥有的现金数
         * dp[i][1]: 手上持有股票时，我们拥有的现金数
         * dp[i][2]: 手上不持有股票，并且今天是由于卖出股票而不持股，我们拥有的现金数(冷冻期)
         */
        for (int i = 1; i < len; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }

    public int maxProfit02(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = -prices[0];
        dp[2] = 0;

        int pre0 = dp[0];
        int pre2 = dp[2];
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], pre2);
            dp[1] = Math.max(dp[1], pre0 - prices[i]);
            dp[2] = dp[1] + prices[i];

            pre0 = dp[0];
            pre2 = dp[2];
        }
        return Math.max(dp[0], dp[2]);
    }

}
