package leetCode.hashTable;
/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 *
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 *
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 *
 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *
 * 提示：
 *     0 <= s.length <= 1000
 *     t.length == s.length + 1
 *     s 和 t 只包含小写字母
 */
public class findTheDifference_389 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了76.78% 的用户
     * 内存消耗：37.2 MB, 在所有 Java 提交中击败了22.14% 的用户
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char res = ' ';
        int[] table = new int[26];
        for (char c : t.toCharArray()) {
            table[c - 'a']++;
        }
        for(char c : s.toCharArray()){
            table[c - 'a']--;
        }
        for (int i = 0; i < table.length; i++) {
            if (table[i] == 1) {
                res = (char) ((char)i + 'a');
            }
        }
        return res;
    }
}
