package leetCode.hashTable;

import java.awt.geom.FlatteningPathIterator;
import java.util.HashMap;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class longestPalindrome_409 {
    public static void main(String[] args) {
        int i = longestPalindrome01("ccc");
        System.out.println(i);
    }

    /**
     * 执行用时 :11 ms, 在所有 Java 提交中击败了19.96% 的用户
     * 内存消耗 :37.7 MB, 在所有 Java 提交中击败了5.25%的用户
     * @param s
     * @return
     */
    public static int longestPalindrome01(String s) {
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 0) {
                res += map.get(c);
            } else {
                res += (map.get(c)-1);
            }
        }
        return res < s.length()?res+1:res;
    }

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了76.48% 的用户
     * 内存消耗 :37.5 MB, 在所有 Java 提交中击败了5.25%的用户
     * @param s
     * @return
     */
    public static int longestPalindrome02(String s){
        int[] count = new int[58];
        for (char c : s.toCharArray()) {
            count[c-'A'] += 1;
        }
        int res = 0;
        for (int i : count) {
            if (i % 2 == 0) {
                res += i;
            } else {
                res += (i-1);
            }
        }
        return res < s.length()?res+1:res;
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :37.7 MB, 在所有 Java 提交中击败了5.25%的用户
     * @param s
     * @return
     */
    public static int longestPalindrome03(String s){
        int[] count = new int[58];
        for (char c : s.toCharArray()) {
            count[c-'A'] += 1;
        }
        int res = 0;
        for (int i : count) {
            //i&1=1说明i是奇数，等于0说明是偶数
            res += i - (i & 1);
        }
        return res < s.length()?res+1:res;
    }
}
