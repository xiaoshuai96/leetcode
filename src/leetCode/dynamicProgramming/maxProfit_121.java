package leetCode.dynamicProgramming;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 *
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 * 思路：要卖出的利润最大，
 */
public class maxProfit_121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    /**
     * DP
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];
        //dp[i][0]代表的是在第i天结束的时候，不持股，手上拥有的现金数
        //dp[i][1]代表的是在第i天结束的时候，持股，手上拥有的现金数
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            /**
             * dp[i][0] 第i天结束的时候不持股
             * 等于 max（前一天不持股的最大现金数，前一天持股的最大现金数+今天卖出的钱）
             * dp[i][1] 第i天结束的时候持股
             * 等于 max（前一天持股的最大现金数，今天的新买的股票）
             */
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    public static int maxProfit00(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[] dp = new int[2];
        //dp[i][0]代表的是在第i天结束的时候，不持股，手上拥有的现金数
        //dp[i][1]代表的是在第i天结束的时候，持股，手上拥有的现金数
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < len; i++) {
            /**
             * dp[i][0] 第i天结束的时候不持股
             * 等于 max（前一天不持股的最大现金数，前一天持股的最大现金数+今天卖出的钱）
             * dp[i][1] 第i天结束的时候持股
             * 等于 max（前一天持股的最大现金数，今天的新买的股票）
             */
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        return dp[0];
    }

    /**
     *思路：只要我们记录下历史最低点的股票价格，那最好的利润就是当前的价格减去最低点的价格
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.57% 的用户
     * 内存消耗 :42.9 MB, 在所有 Java 提交中击败了5.02%的用户
     * @param prices
     * @return
     */
    public static int maxProfit01(int[] prices) {
        int minPrices = Integer.MAX_VALUE;
        int maxPrices = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrices) {
                minPrices = prices[i];
            } else if (prices[i] - minPrices > maxPrices) {
                maxPrices = prices[i] - minPrices;
            }
        }
        return maxPrices;
    }

    /**
     * 执行用时 :403 ms, 在所有 Java 提交中击败了5.62% 的用户
     * 内存消耗 :43.1 MB, 在所有 Java 提交中击败了5.02%的用户
     * @param prices
     * @return
     */
    public static int maxProfit02(int[] prices) {
        int maxPrices = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1;j < prices.length;j++){
                if (prices[i] < prices[j]) {
                    maxPrices = Math.max(maxPrices,prices[j] - prices[i]);
                }
            }
        }
        return maxPrices;
    }

    /**
     * 少用了一个Math方法，增加了一个变量curr，记录此时的差值
     * 执行用时 :290 ms, 在所有 Java 提交中击败了12.51% 的用户
     * 内存消耗 :42.9 MB, 在所有 Java 提交中击败了5.02%的用户
     * @param prices
     * @return
     */
    public static int maxProfit03(int[] prices) {
        int maxPrices = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1;j < prices.length;j++){
                int curr = prices[j] - prices[i];
                if (curr > maxPrices) {
                    maxPrices = curr;
                }
            }
        }
        return maxPrices;
    }
}
