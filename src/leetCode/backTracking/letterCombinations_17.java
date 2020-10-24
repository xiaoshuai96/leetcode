package leetCode.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同  九宫格）。注意 1 不对应任何字母。
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 */
public class letterCombinations_17 {
    public static void main(String[] args) {
        List<String> list = new letterCombinations_17().letterCombinations("89");
        for (String s : list) {
            System.out.println(s);
        }
    }
    List<String> res = new ArrayList<>();
    String[] target = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了33.84% 的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了36.27% 的用户
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return res;
        }
        backTracking(digits,0,"");

        return res;
    }
    public void backTracking(String digits,int index,String s){
        if (s.length() == digits.length()) {
            res.add(s);
            return ;
        }
        //获取目标字符串中的一个字符（数字）
        char c = digits.charAt(index);
        //获取该数字对应九宫格上的字符串
        String str = target[c - '0'];
        for (int i = 0;i < str.length();i++){
            backTracking(digits,index + 1,s + str.charAt(i) );
        }

    }
}
