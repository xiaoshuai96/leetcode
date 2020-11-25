package leetCode.string;

import java.util.Arrays;
import java.util.IllegalFormatFlagsException;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
 * 则输出"student. a am I"。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 说明：
 *     无空格字符构成一个单词。
 *     输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *     如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class reverseWords_offer_58_I {
    public static void main(String[] args) {
        String split = "a good   example";
        String s = new reverseWords_offer_58_I().reverseWords02(split);
        System.out.println(s);
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了88.81% 的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了96.78% 的用户
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String ss = s.trim();
        if (ss.length() == 0) {
            return ss;
        }
        StringBuffer sb = new StringBuffer(ss.length());
        String[] split = ss.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            if ("".equals(split[i])) continue;
            sb.append(split[i]+" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了42.21% 的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了86.87% 的用户
     * @param s
     * @return
     */
    public String reverseWords02(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }
}
