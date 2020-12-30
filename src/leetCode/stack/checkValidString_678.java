package leetCode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *     任何左括号 ( 必须有相应的右括号 )。
 *     任何右括号 ) 必须有相应的左括号 ( 。
 *     左括号 ( 必须在对应的右括号之前 )。
 *     * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 *     一个空字符串也被视为有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: True
 *
 * 示例 2:
 * 输入: "(*)"
 * 输出: True
 *
 * 示例 3:
 * 输入: "(*))"
 * 输出: True
 *
 * 注意:
 *     字符串大小将在 [1，100] 范围内。
 */
public class checkValidString_678 {
    public static void main(String[] args) {
        boolean b = new checkValidString_678().checkValidString("(*))");
        System.out.println(b);
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了62.50% 的用户
     * 内存消耗：36.1 MB, 在所有 Java 提交中击败了90.81% 的用户
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        //两个栈，一个用来存储左括号的下标，一个用来存储*号的下标
        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> star = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            //遇见( 或者 * 就将他们在s中对应的位置下标压入对应的栈中
            if (s.charAt(i) == '(') {
                left.addLast(i);
            } else if (s.charAt(i) == '*') {
                star.addLast(i);
            } else {
                //遇见 ) 之后，优先和(中的进行匹配，如果left中为空，则和star中的任意一个进行匹配
                //如果两个栈都为空，那么说明s不符合有效字符串的定义，直接返回false即可
                if (!left.isEmpty()) {
                    left.pollLast();
                } else if (!star.isEmpty()) {
                    star.pollLast();
                } else {
                    return false;
                }
            }
        }
        // 当遍历完s之后，)一定是被匹配完了，但是可能存在剩余的( ，剩余的*个数无所谓（题目中已经说明）
        //如果(括号的下标大于*的下标，他们是一定无法组合成有效字符串的，细品……
        //小于的就可以正常匹配，最后判断left是否为空，如果为空，返回true，否则返回false
        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.pollLast() > star.pollLast()) return false;
        }
        return left.isEmpty();
    }
}
