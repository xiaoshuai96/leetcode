package leetCode.string;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 */
public class replaceSpace_offer_05 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.7 MB, 在所有 Java 提交中击败了45.60% 的用户
     * @param s
     * @return
     */
    public static String replaceSpace(String s){
        return s.replace(" ","%20");
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了92.74% 的用户
     * @param s
     * @return
     */
    public static String replaceSpace02(String s){
        if (s.length() == 0 || s == null) return s;
        int p = 0;
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < s.length();i++){
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}
