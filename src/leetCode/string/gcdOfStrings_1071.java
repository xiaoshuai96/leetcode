package leetCode.string;
/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 *
 *
 * 示例 1：
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 *
 * 示例 2：
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 *
 * 示例 3：
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *
 * 提示：
 *
 *     1 <= str1.length <= 1000
 *     1 <= str2.length <= 1000
 *     str1[i] 和 str2[i] 为大写英文字母
 *
 */
public class gcdOfStrings_1071 {
    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABC";
        String s = gcdOfStrings(str1, str2);
        System.out.println(52%32);
    }

    /**
     * @param str1
     * @param str2
     * @return
     */
    public static String gcdOfStrings(String str1, String str2) {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));

    }
    public static int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
