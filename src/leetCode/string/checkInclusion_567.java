package leetCode.string;
/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 *
 * 示例 1：
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 示例 2：
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 提示：
 *     输入的字符串只包含小写字母
 *     两个字符串的长度都在 [1, 10,000] 之间
 */
public class checkInclusion_567 {
    public static void main(String[] args) {
        String s1 = "abc",s2 = "dcda";
        boolean b = new checkInclusion_567().checkInclusion(s1, s2);
        System.out.println(b);
    }

    /**
     * 执行用时：223 ms, 在所有 Java 提交中击败了6.94% 的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了5.01% 的用户
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(),len2 = s2.length();
        if (len1 > len2) return false;
        for (int i = 0; i < len2; i++) {
            if ((len1 + i) <= len2 && judge(s1, s2.substring(i, len1 + i))) {
                return true;
            }
        }
        return false;
    }
    /**
     * 默认s1和s2的长度总是相等
     * @param s1
     * @param s2
     * @return
     */
    private boolean judge(String s1,String s2){
        int[] table = new int[26];
        for (char c : s1.toCharArray()){
            table[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            table[c - 'a']--;
        }
        for (int i : table) {
            if (i != 0) return false;
        }
        return true;
    }
}
