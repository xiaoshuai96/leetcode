package leetCode.backTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 *
 * 示例 1：
 * 输入：n = 1
 * 输出：5
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 *
 * 示例 2：
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 *
 * 示例 3：
 * 输入：n = 33
 * 输出：66045
 *
 *
 * 提示：
 *     1 <= n <= 50
 */
public class countVowelStrings_1641 {
    public static void main(String[] args) {
        int i = new countVowelStrings_1641().countVowelStrings(7);
        System.out.println(i);
    }

    /**
     * 一顿操作猛如虎，一看执行5%
     * 执行用时：719 ms, 在所有 Java 提交中击败了5.02% 的用户
     * 内存消耗：108.1 MB, 在所有 Java 提交中击败了5.03% 的用户
     * @param n
     * @return
     */
    public int countVowelStrings(int n) {
        if (n < 1) return 0;
        List<String> list = new LinkedList<>();
        String[] target = {"a","e","i","o","u"};
        backTrack(list,new StringBuilder(n),n,target,0);
        return list.size();
    }
    private void backTrack(List<String> list, StringBuilder sb, int n, String[] target,int curr) {
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }
        for (int i = curr; i < target.length; i++) {
            sb.append(target[i]);
            backTrack(list, sb, n, target,i);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public int countVowelStrings02(int n) {
        int[] dp = new int[5];
        int res = 0;
        //初始化dp数组
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < 5; j++) {
                dp[j] += dp[j-1];
            }
        }
        for(int cnt : dp) res += cnt;
        return res;
    }

}
