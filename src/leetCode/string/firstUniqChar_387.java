package leetCode.string;

import java.util.*;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 示例：
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 * 提示：你可以假定该字符串只包含小写字母。
 */
public class firstUniqChar_387 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        int i = new firstUniqChar_387().firstUniqChar(s);
        System.out.println(i);
    }

    /**
     * 执行用时：36 ms, 在所有 Java 提交中击败了28.81% 的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了44.25% 的用户
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了87.90% 的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了69.22% 的用户
     * @param s
     * @return
     */
    public int firstUniqChar02(String s) {
        int[] arr = new int[26];
        int n = s.length();
        //按字符串s的顺序存进去
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)-'a']++ ;
        }
        //检验的时候依然按照s的顺序，碰到的第一个值为1的就是符合要求的
        for (int i = 0; i < n; i++) {
            if (arr[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }


}
