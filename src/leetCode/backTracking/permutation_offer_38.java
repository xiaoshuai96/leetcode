package leetCode.backTracking;

import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 限制：
 * 1 <= s 的长度 <= 8
 */
public class permutation_offer_38 {
    public static void main(String[] args) {
        String s = "aa";
        String[] permutation = new permutation_offer_38().permutation(s);
        System.out.println(Arrays.toString(permutation));
    }

    /**
     * 执行用时：45 ms, 在所有 Java 提交中击败了20.53% 的用户
     * 内存消耗：42.9 MB, 在所有 Java 提交中击败了84.41% 的用户
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        boolean[] marked = new boolean[s.length()];
        //去重
        Set<String> res = new HashSet<String>();
        backTrack(res,new StringBuilder(),s,marked);
        return res.toArray(new String[res.size()]);
    }

    /**
     * 使用marked来标记当前字母是否使用过
     * @param res
     * @param sb
     * @param s
     * @param marked
     */
    private void backTrack(Set<String> res,StringBuilder sb,String s,boolean[] marked){
        if (s.length() == sb.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!marked[i]) {
                marked[i] = true;
                sb.append(s.charAt(i));
                backTrack(res, sb, s, marked);
                sb.deleteCharAt(sb.length() - 1);
                marked[i] = false;
            }
        }
    }
}
