package leetCode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），
 * 以使得到的括号字符串有效。
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 *     它是一个空字符串，或者
 *     它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 *     它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 *
 * 示例 1：
 * 输入："())"
 * 输出：1
 *
 * 示例 2：
 * 输入："((("
 * 输出：3
 *
 * 示例 3：
 * 输入："()"
 * 输出：0
 *
 * 示例 4：
 * 输入："()))(("
 * 输出：4
 *
 * 提示：
 *     S.length <= 1000
 *     S 只包含 '(' 和 ')' 字符。
 */
public class minAddToMakeValid_921 {
    public static void main(String[] args) {
        String s = "(((";
        int i = new minAddToMakeValid_921().minAddToMakeValid02(s);
        System.out.println(i);
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了55.41% 的用户
     * 内存消耗：36.9 MB, 在所有 Java 提交中击败了13.02% 的用户
     * @param S
     * @return
     */
    public int minAddToMakeValid(String S) {
        //两个栈，分别用来存储(和)在字符串S中的下标
        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> right = new LinkedList<>();
        //遍历字符串S，如果遇见左括号就直接压入栈中
        //如果遇见右括号，查看left是否为空，如果不为空，则可以匹配一对括号，否则压入right中
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                left.addLast(i);
            } else {
                if (!left.isEmpty()) {
                    left.pollLast();
                } else {
                    right.addLast(i);
                }
            }
        }
        //最终left和right中剩余的括号个数就是必须添加的最少括号数
        return left.size() + right.size();
    }

    /**
     * 空间复杂度优化
     * 算法思路还是和版本1相同的
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.7 MB, 在所有 Java 提交中击败了34.71% 的用户
     * @param S
     * @return
     */
    public int minAddToMakeValid02(String S){
        int left = 0,right = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                left++;
            } else {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        return left + right;
    }
}
