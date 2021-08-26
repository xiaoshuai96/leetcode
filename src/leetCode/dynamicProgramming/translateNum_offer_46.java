package leetCode.dynamicProgramming;
/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 提示：
 *     0 <= num < 2^31
 */
public class translateNum_offer_46 {
    /**
     * 设dp[i]表示为以第i个数字结尾的数字可最多翻译的方法数
     * 其中我们对于每两个两个的数字进行翻译，有两种情况：
     * 1.该数字在10-25之间，那么该数字可以翻译成两种，例如13可以翻译成“bd” or “n”，10可以翻译成“ba” or “k”;
     * 2.该数字大于25，那么我们只有一种翻译方式，例如26只能被翻译成“cf”
     *
     * 初始化  无数字dp[0] = 有一位数字dp[1] = 1
     * Q：为什么无数字dp[0] = 1呢？
     * A：当两位的数字的范围在[10,25]中的时候，显然它们可以翻译的方法数有两种，故推出dp[0] = 1
     *
     * 状态转移方程：
     *    X --> [10,25]            dp[i] = dp[i - 1] + dp[i - 2]
     *    X --> [0,10) U (25,99]   dp[i] = dp[i - 1]
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            String tmp = s.substring(i - 2, i);
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];

    }

    public int translateNum02(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}
