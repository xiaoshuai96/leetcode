package leetCode.string;

import java.util.Arrays;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 *
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *
 * 提示：
 *
 *     字符串长度在[0, 50000]范围内。
 *
 */
public class compressString_interview_0106 {
    public static void main(String[] args) {
        String S = "abbccd";
        String s = compressString(S);
        System.out.println(s);
    }

    /**
     * 执行用时 :84 ms, 在所有 Java 提交中击败了13.58% 的用户
     * 内存消耗 :44.8 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param S
     * @return
     */
    public static String compressString(String S) {
        if (S.length() == 0 || S.length() == 1) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        int curr = 0, next = 1;
        String[] split = S.split("");
        while (next < split.length) {
            //判断当前sb的长度如果大于原字符串的长度，提前结束循环
            if (sb.length() > S.length()) return S;
            if (split[curr].equals(split[next])) {
                next++;
            } else {
                sb.append(split[curr]+(next - curr));
                curr = next;
                next++;
            }
        }
        //将最后剩余的字母进行补充
        sb.append(split[split.length-1]+(next - curr));
        return sb.length() >= S.length() ? S : sb.toString();
    }

}
