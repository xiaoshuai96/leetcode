package leetCode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 *
 * 提示：
 *     1 <= S.length <= 20000
 *     S 仅由小写英文字母组成。
 */
public class removeDuplicates_1047 {
    /**
     * 执行用时：23 ms, 在所有 Java 提交中击败了62.07% 的用户
     * 内存消耗：40.4 MB, 在所有 Java 提交中击败了10.10% 的用户
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        if (s.length() <= 1) return s;
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (c == stack.peekLast()) {
                    stack.pollLast();
                } else {
                    stack.addLast(c);
                }
            } else {
                stack.addLast(c);
            }
        }
        StringBuffer sb = new StringBuffer(stack.size());
        for (Character c : stack) sb.append(c);
        return sb.toString();
    }

    /**
     * 执行用时：10 ms, 在所有 Java 提交中击败了90.72% 的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了24.07% 的用户
     * @param S
     * @return
     */
    public String removeDuplicates02(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }
}
