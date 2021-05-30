package leetCode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 *
 * 示例 1：
 * 输入：s = "(abcd)"
 * 输出："dcba"
 *
 * 示例 2：
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 *
 * 示例 3：
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 *
 * 示例 4：
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *
 * 提示：
 *     0 <= s.length <= 2000
 *     s 中只有小写英文字母和括号
 *     我们确保所有括号都是成对出现的
 */
public class reverseParentheses_1190 {
    public static void main(String[] args) {
        String s = "a(bcdefghijkl(mno)p)q";
        String s1 = new reverseParentheses_1190().reverseParentheses(s);
        System.out.println(s1);
    }

    /**
     * solution ： stack
     * nlogn ： O(n^2)
     * note：遍历字符串，如果当前字符是'('，将存储在sb中的内存压入栈中，然后将sb置空
     * 如果遇到的是')'，则反转整个sb，并将栈顶的字符串插入到sb的头部
     * 如果是其他字符（小写字母），则追加到sb中即可
     * @param s
     * @return
     */
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (c == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * solution : Pretreatment
     * nlogn : O(n)
     * note : 如上的解法中使用到了Java自带的api，循环中嵌套了字符串反转的方法，程序整体的时间复杂度达到了O(n^2)
     * 以下解法的思路：
     * 当我们遍历到了
     * @param s
     * @return
     */
    public String reverseParentheses02(String s){
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuffer sb = new StringBuffer();
        int index = 0,step = 1;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }
}
