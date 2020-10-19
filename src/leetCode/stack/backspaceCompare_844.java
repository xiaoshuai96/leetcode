package leetCode.stack;

import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，
 * 判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 示例 1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 *
 * 示例 2：
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 *
 * 示例 3：
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 *
 * 示例 4：
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 *
 *
 * 提示：
 *
 *     1 <= S.length <= 200
 *     1 <= T.length <= 200
 *     S 和 T 只含有小写字母以及字符 '#'。
 *
 *
 *
 * 进阶：你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 */
public class backspaceCompare_844 {
    public static void main(String[] args) {
        String S = "a##c",T = "#a#c";
        boolean b = new backspaceCompare_844().backspaceCompare(S, T);
        System.out.println(b);

    }

    /**
     * 双指针
     * 执行用时：1 ms, 在所有 Java 提交中击败了96.52% 的用户
     * 内存消耗：35.9 MB, 在所有 Java 提交中击败了100.00% 的用户
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了74.87% 的用户
     * 内存消耗：36.5 MB, 在所有 Java 提交中击败了98.48% 的用户
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare01(String S,String T){
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        iterator(S,stack1);
        iterator(T,stack2);
        /**对处理之后的两个栈进行判断：
         * 如果大小相同，再进行每个字符的比较（只要有一个不相同，即返回false）
         * 如果大小不同，直接返回false即可
         */
        if (stack1.size() == stack2.size()) {
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                if (stack1.pop() != stack2.pop()) {
                    return false;
                }
            }
        }else return false;
        return true;
    }
    private void iterator(String s,Stack<Character> stack){
        /**
         * 如果当前字符是‘#’，那么看栈中是否空，如果为空就跳过此次循环
         * 如果不为空，则弹出栈顶的元素之后开始下一次循环
         */
        for (char c : s.toCharArray()){
            if (c == '#') {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
    }

    /**
     * 字符串重构
     * 思路与method01相同
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了96.52% 的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了99.88% 的用户
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare02(String S,String T){
        return rebuild(S).equals(rebuild(T));
    }
    private String rebuild(String s){
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c != '#') {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }

}
