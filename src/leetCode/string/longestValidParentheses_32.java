package leetCode.string;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class longestValidParentheses_32 {
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (c == '(') {
                    stack.push(c);
                    continue;
                }
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                    res += 2;
                }
            }
        }
        return  res;
    }
}
