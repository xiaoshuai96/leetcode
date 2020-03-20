package leetCode.string;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 *
 * 限制：
 *
 *     1 <= k < s.length <= 10000
 */
public class reverseLeftWords_interview_58 {
    public static void main(String[] args) {
        String s = "abcdefg";
        String s1 = reverseLeftWords02(s, 2);
        System.out.println(s1);
    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :39.9 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords01(String s,int n){
        if (s.length() == 0 || s.length() == 1) return s;
        String res = "";
        res = s.substring(n,s.length());
        res += s.substring(0,n);
        return res;
    }

    /**
     * 执行用时 :74 ms, 在所有 Java 提交中击败了5.03% 的用户
     * 内存消耗 :42.2 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords02(String s,int n){
        if (s.length() == 0 || s.length() == 1) return s;
        String s1 = "";
        for (int i = n; i < s.length(); i++) {
            s1 += s.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            s1 += s.charAt(i);
        }
        return s1;
    }
}
