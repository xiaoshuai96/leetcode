package leetCode.backTracking;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 * 示例1:
 *  输入：S = "qqe"
 *  输出：["eqq","qeq","qqe"]
 *
 * 示例2:
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 *
 * 提示:
 *     字符都是英文字母。
 *     字符串长度在[1, 9]之间。
 */
public class permutation_interview_08_08 {
    public static void main(String[] args) {
        String s = "qe";

    }

    /**
     * 执行用时：69 ms, 在所有 Java 提交中击败了32.12% 的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了76.17% 的用户
     * @param S
     * @return
     */
    public String[] permutation(String S) {
        Set<String> res = new HashSet<>();
        //使用一个和字符串相等长度的boolean数组来表示字符串中的哪个字符使用过
        combination(res,S,new StringBuilder(),new boolean[S.length()]);
        return res.toArray(new String[res.size()]);
    }

    private void combination(Set<String> res, String s, StringBuilder sb, boolean[] marked){
        if(sb.length() == s.length()){
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!marked[i]) {
                marked[i] = true;
                sb.append(s.charAt(i));
                combination(res, s, sb, marked);
                sb.deleteCharAt(sb.length() - 1);
                marked[i] = false;
            }
        }
    }
}
