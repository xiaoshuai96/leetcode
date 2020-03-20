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
 * 暴力解法思路：先生成括号的所有组合，然后判断有效组合并存入list中。
 */
public class generateParenthesis_22_unfinished {
    public static void main(String[] args) {
        generateParenthesis(3);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String s = "()()";
        char[] chars = s.toCharArray();

        return list;
    }

}
