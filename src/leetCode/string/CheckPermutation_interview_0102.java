package leetCode.string;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 *
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 *
 * 说明：
 *
 *     0 <= len(s1) <= 100
 *     0 <= len(s2) <= 100
 */
public class CheckPermutation_interview_0102 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：35.9 MB, 在所有 Java 提交中击败了96.08% 的用户
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length())return false;
        int[] mark = new int[26];
        for(char c : s1.toCharArray()){
            mark[c - 'a']++;
        }
        for(char c : s2.toCharArray()){
            mark[c - 'a']--;
        }
        for (int i : mark) {
            if (i < 0) return false;
        }
        return true;
    }
}
