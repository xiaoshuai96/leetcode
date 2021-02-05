package leetCode.backTracking;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 *
 * 输入：S = "12345"
 * 输出：["12345"]
 *
 *
 * 提示：
 *     S 的长度不超过12。
 *     S 仅由数字和字母组成。
 */
public class letterCasePermutation_784 {
    public static void main(String[] args) {
        List<String> list = new letterCasePermutation_784().letterCasePermutation("a1b2");
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * 这个题目分析之后实际上可以用二叉树来表示
     * 对于每一个非数字字符存在两种情况
     * 1.如果当前字符是小写字符，即可以小写也可以大写
     * 2.如果当前字符是大写字符，既可以大写也可以小写
     * 对于a1b2来说
     *                          a 1 b 2
     *              a1b2                        A1b2
     *
     *              a1b2                        A1b2
     *
     *         a1b2     a1B2               A1b2     A1B2
     *
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了95.90% 的用户
     * @param s
     * @return
     */
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        dfs(res,s.toCharArray(),0);
        return res;
    }
    private void dfs(List<String> res,char[] charArray,int index){
        if (index == charArray.length) {
            res.add(new String(charArray));
            return ;
        }
        dfs(res, charArray, index + 1);
        if (Character.isLetter(charArray[index])) {
            charArray[index] ^= 1 << 5;
            dfs(res, charArray, index + 1);
        }
    }
}
