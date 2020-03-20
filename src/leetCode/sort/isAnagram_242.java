package leetCode.sort;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.CountDownLatch;

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
 */
public class isAnagram_242 {
    public static void main(String[] args) {
        String s = "a";
        String t = "ab";
        System.out.println(isAnagram01(s, t));

    }
    //version 1.0
    public static boolean isAnagram01(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        String[] ss = s.split("");
        String[] tt = t.split("");
        List<String> list = new ArrayList<>(Math.max(ss.length,tt.length));
        for (String s1 : ss) {
            list.add(s1);
        }
        for (String t1 : tt) {
            if (list.contains(t1)) {
                list.remove(t1);
            }
        }
        return list.isEmpty();
    }
    //version 2.0
    public static boolean isAnagram02(String s, String t) {
        if (s.length() != t.length()) return false;
        String[] ss = s.split("");
        String[] tt = t.split("");
        Arrays.sort(ss);
        Arrays.sort(tt);
        return Arrays.equals(ss,tt);
    }
    //version 2.1
    public static boolean isAnagram03(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);
    }
    //version 3.0 实际上与版本1.0的思路是相同的，但是版本一占用的内存太大
    public static boolean isAnagram04(String s,String t){
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];//26个字母
        for (int i = 0;i < s.length();i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

}
