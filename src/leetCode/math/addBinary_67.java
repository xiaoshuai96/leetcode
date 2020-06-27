package leetCode.math;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 *
 *
 * 提示：
 *
 *     每个字符串仅由字符 '0' 或 '1' 组成。
 *     1 <= a.length, b.length <= 10^4
 *     字符串如果不是 "0" ，就都不含前导零。
 */
public class addBinary_67 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了59.58% 的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了7.69% 的用户
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a,String b){
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

    /**
     * 1.  0   0   ->   0   flag = 0
     * 2.  0   1   ->   1   flag = 0
     * 3.  1   0   ->   1   flag = 0
     * 4.  1   1   ->   0   flag = 1
     * @param a
     * @param b
     * @return
     */
    public static String addBinary02(String a,String b){
        int temp = transNumber(a)+transNumber(b);
        return transBinary(temp);
    }

    /**
     * 二进制转换为十进制
     * @param s
     * @return
     */
    private static int transNumber(String s){
        if (s.length() == 1 && s.charAt(0) == '0') {
            return 0;
        }
        int res = 0,len = s.length()-1;
        for(int i = 0;i < s.length();i++){
            res += ((s.charAt(i)-48)*Math.pow(2,len--));
        }
        return res;
    }

    /**
     * 十进制转换为二进制
     * @param a
     * @return
     */
    private static String transBinary(int a){
        if (a == 0 || a == 1) {
            return String.valueOf(a);
        }
        StringBuilder s = new StringBuilder();
        while (a != 0) {
            s.append((a%2)+"");
            a /= 2;
        }
        return s.reverse().toString();
    }
}
