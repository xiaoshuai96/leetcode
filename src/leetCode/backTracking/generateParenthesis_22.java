package leetCode.backTracking;
import java.util.ArrayList;
import java.util.List;
/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class generateParenthesis_22 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了95.65% 的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了48.12% 的用户
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list,"",n,n);
        return list;
    }
    private void dfs(List<String> list, String s, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(s);
            return;
        }
        if (left > right) {
            return ;
        }
        if (left > 0) {
            dfs(list,s + "(",left - 1,right);
        }
        if (right > 0) {
            dfs(list,s + ")",left,right - 1);
        }

    }

}
