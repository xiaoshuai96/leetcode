package leetCode.hashTable;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class isAnagram_242 {
    public static void main(String[] args) {
        String s = "zlap";
        String t = "kcqx";
        boolean b = new isAnagram_242().isAnagram(s, t);
        System.out.println(b);
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了64.37% 的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了94.19% 的用户
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen) return false;
        int[] sword = new int[26];
        int[] tword = new int[26];
        for(int i = 0;i < slen;i++){
            sword[s.charAt(i) - 'a']++;
            tword[t.charAt(i) - 'a']++;
        }
        for(int i = 0;i < sword.length;i++){
            if (sword[i] != tword[i]) return false;
        }
        return true;
    }
}
