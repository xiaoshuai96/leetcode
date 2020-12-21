package leetCode.string;

/**
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（
 * 比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 *
 * 示例2:
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 *
 * 提示
 *     字符串长度在[0, 100000]范围内。
 *
 * 说明:
 *     你能只调用一次检查子串的方法吗？
 */
public class isFlipedString_interview_0109 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了97.02% 的用户
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        //erbottlewat + erbottlewat
        String ss = s2 + s2;
        return ss.contains(s1);
    }
}
