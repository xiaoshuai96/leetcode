package leetCode.string;
/**
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 * 示例 1：
 * 输入：s = "Hello"
 * 输出："hello"
 *
 * 示例 2：
 * 输入：s = "here"
 * 输出："here"
 *
 * 示例 3：
 * 输入：s = "LOVELY"
 * 输出："lovely"
 *
 *
 * 提示：
 *     1 <= s.length <= 100
 *     s 由 ASCII 字符集中的可打印字符组成
 */
public class toLowerCase_709 {
    /**
     * 大写变小写、小写变大写 : 字符 ^= 32;
     *
     * 大写变小写、小写变小写 : 字符 |= 32;
     *
     * 小写变大写、大写变大写 : 字符 &= -33;
     * @param s
     * @return
     */
    public String toLowerCase(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder(len);
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                res.append(c |= 32);
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
