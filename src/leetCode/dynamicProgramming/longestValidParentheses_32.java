package leetCode.dynamicProgramming;
/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * 示例 1：
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 *
 * 示例 2：
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 *
 * 示例 3：
 * 输入：s = ""
 * 输出：0
 *
 *
 *
 * 提示：
 *     0 <= s.length <= 3 * 10^4
 *     s[i] 为 '(' 或 ')'
 */
public class longestValidParentheses_32 {
    public static void main(String[] args) {
        String s = "())((())";
        new longestValidParentheses_32().longestValidParentheses(s);

    }
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            //右括号再判断
            if (s.charAt(i) == ')') {
                //如果当前右括号前面是左括号，刚好可以凑出一对有效括号
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                //如果当前括号前面是右括号，则往前找，和他相匹配的左括号
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
