package leetCode.twoPointers;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 *
 * AmanaplanacanalPanama
 */
public class isPalindrome_125 {
    public static void main(String[] args) {
        String s = "";
        boolean b = isPalindrome(s);
        System.out.println(b);
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了39.16% 的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了7.14% 的用户
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s){
        //[A-Z]|[a-z]|[0-9]
        StringBuilder ss = new StringBuilder();
        for (char c : s.toCharArray()){
            if ((c >= 'a' && c <= 'z')||(c >= 'A' && c <= 'Z')||(c >= 48 && c <= 57)) {
                ss.append(c);
            }
        }
        String sb = ss.toString().toLowerCase();
        if (sb.length() == 0) return true;
        int left = 0,right = sb.length()-1;
        while (left <= right){
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
