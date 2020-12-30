package leetCode.Depth_Breadth_FirstSearch;

import java.util.LinkedList;
import java.util.List;
/**
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
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
 */
public class generateParenthesis_interview_0809 {
    public static void main(String[] args) {
        List<String> list = new generateParenthesis_interview_0809().generateParenthesis(2);
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了27.54% 的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了44.74% 的用户
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        dfs(res,"",n,n);
        return res;
    }
    /**
     *
     * @param res
     * @param s
     * @param left 目前可供选择的左括号的个数
     * @param right 目前可供选择的右括号的个数
     */
    private void dfs(List<String> res,String s,int left,int right){
        if (left == 0 && right == 0) {
            res.add(s);
            return ;
        }
        //如果左边括号的个数大于右边括号的个数，提前截止
        if (left > right) {
            return ;
        }
        if (left > 0) {
            dfs(res,s + "(",left - 1,right);
        }
        if (right > 0) {
            dfs(res,s + ")",left,right - 1);
        }
    }
}
