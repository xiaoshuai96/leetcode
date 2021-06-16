package leetCode.dynamicProgramming;
/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *
 * 提示：
 *     1 <= s.length <= 1000
 *     s 仅由数字和英文字母（大写和/或小写）组成
 */
public class longestPalindrome_5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int begin = 0;
        int maxLen = 1;
        char[] charArray = s.toCharArray();
        //dp[i][j]表示的就是在s中的i到j的子串是否是回文串
        boolean[][] dp = new boolean[len][len];
        //单个字符一定是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[j] != charArray[i]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
