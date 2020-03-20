package leetCode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 *
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 *
 * 限制：
 *
 *     0 <= len(s) <= 100
 *     如果你不使用额外的数据结构，会很加分。
 *
 */
public class isUnique_interview {
    public static void main(String[] args) {
        String s = "abcd";
        boolean unique = isUnique(s);
        System.out.println(unique);
    }

    //double percent
    public static boolean isUnique(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            for (int j = i+1;j < astr.length();j++) {
                if (astr.charAt(i) == astr.charAt(j)) return false;
            }
        }
        return true;
    }

    public static boolean isUnique02(String astr) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < astr.length(); i++) {
            if (map.containsKey(astr.charAt(i))) return false;
            map.put(astr.charAt(i),1);
        }
        return true;
    }
}
