package leetCode.hashTable;

import java.util.HashMap;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 *
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 *
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class wordPattern_290 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.94% 的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了77.73% 的用户
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        //有任意一个为null，提前结束
        if (pattern == null || s == null) return false;
        String[] string = s.split(" ");
        //如果规则和string长度不相同，一定是不匹配的，提前返回false
        if (pattern.length() != string.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char tmp = pattern.charAt(i);
            //key已经在
            if (map.containsKey(tmp)) {
                //不对应就失败
                if (!map.get(tmp).equals(string[i])) {
                    return false;
                }
            }
            //key不存在
            else {
                //两个value的值一样 a-dog b-dog->false
                if (map.containsValue(string[i])){
                    return false;
                }else{
                    //添加k-v值
                    map.put(tmp, string[i]);}
            }
        }
        return true;
    }
}
