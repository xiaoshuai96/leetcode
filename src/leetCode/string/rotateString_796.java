package leetCode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串, A 和 B。
 *
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 *
 * 示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 *
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 *
 * 注意：
 *
 *     A 和 B 长度不超过 100。
 *
 */
public class rotateString_796 {
    public static void main(String[] args) {
        rotateString("abcde","abcde");
    }
    //思路：
    // 由于 A + A 包含了所有可以通过旋转操作从 A 得到的字符串，因此我们只需要判断 B 是否为 A + A 的子串即可。
    public static boolean rotateString(String A,String B){
        return A.length() == B.length() && (A+A).contains(B);
    }
}
