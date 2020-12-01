package leetCode.backTracking;

import java.util.*;

/**
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 示例1:
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 *
 * 示例2:
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 *
 * 提示:
 *
 *     字符都是英文字母。
 *     字符串长度在[1, 9]之间。
 */
public class permutation_interview_08_07 {
    public static void main(String[] args) {
        String[] qwes = new permutation_offer_38().permutation("ab");
        System.out.println(Arrays.toString(qwes));
    }

    /**
     * 执行用时：22 ms, 在所有 Java 提交中击败了35.68% 的用户
     * 内存消耗：45.8 MB, 在所有 Java 提交中击败了97.60% 的用户
     * @param S
     * @return
     */
    public String[] permutation(String S) {
        List<String> list = new ArrayList<>();
        //标记S中哪个字符被使用过
        boolean[] marked = new boolean[S.length()];
        backTrack(S, list, new StringBuffer(S.length()),marked);

        //导出最终结果
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    private void backTrack(String s, List<String> list, StringBuffer sb,boolean[] marked){
        if (s.length() == sb.length()) {
            list.add(new String(sb));
            return ;
        }
        for (int i = 0; i < s.length(); i++) {
            // 如果没有被使用过
            if (!marked[i]) {
                // 将该字符添加进Stringbuffer中，然后将标记位设为true代表使用中，在回溯之后，
                // 设为false，代表可以继续使用了
                sb.append(s.charAt(i));
                marked[i] = true;
                backTrack(s, list, sb, marked);
                marked[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
