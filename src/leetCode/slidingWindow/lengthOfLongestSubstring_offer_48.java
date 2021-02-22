package leetCode.slidingWindow;
import java.util.*;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *     s.length <= 40000
 */
public class lengthOfLongestSubstring_offer_48 {
    public static void main(String[] args) {
        String s = "dvdf";
        int i = new lengthOfLongestSubstring_offer_48().lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    /**
     * 执行用时：24 ms, 在所有 Java 提交中击败了8.53% 的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了57.00% 的用户
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int len = s.length();
        int p = 0;
        List<Character> list = new LinkedList<>();
        while (p < len) {
            //如果集合中有重复的,删除最前面的元素，继续观察集合中是否还包含该重复元素
            if (list.contains(s.charAt(p))) {
                res = Math.max(res, list.size());
                while (list.contains(s.charAt(p))) {
                    list.remove(0);
                }
            }
            list.add(s.charAt(p++));
        }
        return Math.max(res, list.size());
    }

    /**
     * 改进版本
     * 使用set本身特性和滑动窗口思想进行遍历
     * 1.如果集合中包含了当前待添加的字符，将left指针指向的元素依次删除，直到集合中不包含待添加字符
     * 2.1步骤完成之后，将字符添加进集合中，然后记录目前窗口大小，每次统计最大值
     * 3.直到右边窗口到达边界，循环结束，返回res
     * 执行用时：9 ms, 在所有 Java 提交中击败了30.94% 的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了70.54% 的用户
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring02(String s) {
        int res = 0;
        int len = s.length();
        int left = 0,right = 0;
        Set<Character> set = new HashSet<>();
        while (right < len) {
            char c = s.charAt(right);
            //如果集合中有重复的,删除最前面的元素，继续观察集合中是否还包含该重复元素
            while (set.contains(c)) {
                //左指针移动
                set.remove(s.charAt(left++));
            }
            set.add(c);
            res = Math.max(res, right - left + 1);
            ++right;
        }
        return res;
    }


    public int lengthOfLongestSubstring03(String s) {
        Map<Character, Integer> table = new HashMap<>();
        int res = 0, temp = 0;
        for(int i = 0;i < s.length();i++) {
            int j = table.getOrDefault(s.charAt(i), -1);
            temp = i - j > temp ? temp + 1 : i - j;
            res = Math.max(res, temp);
            table.put(s.charAt(i), i);
        }
        return res;
    }
}
