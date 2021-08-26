package leetCode.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 提示：
 *     s.length <= 40000
 */
public class lengthOfLongestSubstring_offer_48 {
    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了53.27% 的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了67.65% 的用户
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //记录的是key最近出现在s中的位置下标
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int preMaxLen = 0;
        for (int i = 1; i < s.length(); i++) {
            preMaxLen = Math.min(i - map.getOrDefault(s.charAt(i), -1), preMaxLen + 1);
            max = Math.max(max,preMaxLen);
            map.put(s.charAt(i), i);
        }
        return max;
    }

    public int lengthOfLongestSubstring02(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] chas = s.toCharArray();
        int[] map = new int[256];
        for(int i = 0;i < 256;i++){
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        for(int i = 0;i != chas.length;i++){
            pre = Math.max(pre,map[chas[i]]);
            cur = i - pre;
            len = Math.max(len,cur);
            map[chas[i]] = i;
        }
        return len;
    }
    public int lengthOfLongestSubstring03(String s){
        HashMap<Character, Integer> dic = new HashMap<>();
        //i表示左边边界
        int i = -1,res = 0;
        for (int j = 0; j < s.length(); ++j) {
            if (dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j)));
            }
            dic.put(s.charAt(j), j);
            res = Math.max(res, j - i);
        }
        return res;
    }

}
