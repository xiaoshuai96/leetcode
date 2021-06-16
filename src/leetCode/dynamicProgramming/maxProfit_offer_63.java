package leetCode.dynamicProgramming;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 限制：
 *      0 <= 数组长度 <= 10^5
 */
public class maxProfit_offer_63 {
    /**
     * 执行用时：364 ms, 在所有 Java 提交中击败了5.07% 的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了31.80% 的用户
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    max = Math.max(prices[j] - prices[i], max);
                }
            }
        }
        return max;
    }

    /**
     * dp 01
     * @param prices
     * @return
     */
    public int maxProfit02(int[] prices) {
        int n = prices.length;
        if (n < 1) return 0;
        int minPrice = prices[0];
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice,prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        return dp[n - 1];
    }

    /**
     * 空间优化
     * @param prices
     * @return
     */
    public int maxProfit03(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice,prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);
        }
        return profit;
    }
}
