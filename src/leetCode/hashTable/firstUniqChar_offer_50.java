package leetCode.hashTable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 *
 *
 * 限制：
 * 0 <= s 的长度 <= 50000
 */
public class firstUniqChar_offer_50 {
    public static void main(String[] args) {
        char c = new firstUniqChar_offer_50().firstUniqChar("leetcode");
        System.out.println(c);
    }
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 有序哈希表
     * @param s
     * @return
     */
    public char firstUniqChar02(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }
}
