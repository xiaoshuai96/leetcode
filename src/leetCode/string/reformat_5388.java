package leetCode.string;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.Stack;

/**
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。
 * 也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 *
 * 示例 1：
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。
 * "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 *
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 *
 * 示例 3：
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 *
 * 示例 4：
 * 输入：s = "covid2019"
 * 输出："c2o0v1i9d"
 *
 * 示例 5：
 * 输入：s = "ab123"
 * 输出："1a2b3"
 *
 *
 *
 * 提示：
 *     1 <= s.length <= 500
 *     s 仅由小写英文字母和/或数字组成。
 *
 */
public class reformat_5388 {
    public static void main(String[] args) {
        String s = reformat01("1");
        System.out.println(s);
    }

    /**
     * 执行用时 :22 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :40.6 MB, 在所有 Java 提交中击败了100.00%的用户
     * 这个垃圾代码竟然，只是因为提交的人数太少了  需要优化
     * @param s
     * @return
     */
    public static String reformat01(String s) {
        String s1 = "";
        String s2 = "";
        String result = "";
        for (char c : s.toCharArray()) {
            if (c >= 97 && c <= 122) {
                s1 += c;
            } else {
                s2 += c;
            }
        }
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return "";
        }
        Character[] res = new Character[s1.length()+s2.length()];
        int cha = s1.length() - s2.length();
        int count = 0;
        if (cha >= 0) {
            for (int i = 0; i < res.length; i += 2) {
                res[i] = s1.charAt(count++);
            }
            count = 0;
            for (int i = 1; i < res.length; i += 2) {
                res[i] = s2.charAt(count++);
            }
        } else {
            for (int i = 0; i < res.length; i += 2) {
                res[i] = s2.charAt(count++);
            }
            count = 0;
            for (int i = 1; i < res.length; i += 2) {
                res[i] = s1.charAt(count++);
            }
        }
        for (char c : res) {
            result += c;
        }
        return result;

    }

    /**
     * 执行用时 :13 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :40 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param s
     * @return
     */
    public static String reformat02(String s){
        Stack<Character> stackAZ = new Stack<>();
        Stack<Character> stack09 = new Stack<>();
        Stack<Character> temp;
        String res = "";
        for (char c : s.toCharArray()) {
            if (c >= 97 && c <= 122) {
                stackAZ.push(c);
            } else {
                stack09.push(c);
            }
        }
        int len = stackAZ.size() - stack09.size();
        //如果两个栈的高度之差的绝对值大于1说明不可能组成格式化字符串，返回“”即可
        if (Math.abs(len) > 1) {
            return res;
        }
        if (len < 0) {
            temp = stack09;
            stack09 = stackAZ;
            stackAZ = temp;
        }
        for (stackAZ.size(); stackAZ.size() > 0; ) {
            res += String.valueOf(stackAZ.pop());
            if (!stack09.isEmpty()) {
                res += String.valueOf(stack09.pop());
            }
        }
        return res;
    }
}
