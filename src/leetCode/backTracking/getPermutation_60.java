package leetCode.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *     "123"
 *     "132"
 *     "213"
 *     "231"
 *     "312"
 *     "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 *
 * 示例 1：
 * 输入：n = 3, k = 3
 * 输出："213"
 *
 * 示例 2：
 * 输入：n = 4, k = 9
 * 输出："2314"
 *
 * 示例 3：
 * 输入：n = 3, k = 1
 * 输出："123"
 *
 *
 * 提示：
 *     1 <= n <= 9
 *     1 <= k <= n!
 */
public class getPermutation_60 {
    public static void main(String[] args) {
        String permutation = new getPermutation_60().getPermutation(4, 9);
        System.out.println(permutation);
    }

    public String getPermutation(int n, int k) {
        List<String> res = new ArrayList<>();
        int[] nums = new int[n];
        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backTrack(res,new StringBuffer(),nums,marked,k);
        return res.get(res.size() - 1);
    }
    private void backTrack(List<String> res, StringBuffer ans, int[] nums, boolean[] marked, int k){
        if (ans.length() == nums.length) {
            res.add(new String(ans));
            return ;
        }
        if (k == res.size()) {
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!marked[i]) {
                marked[i] = true;
                ans.append(nums[i]);
                backTrack(res,ans,nums,marked,k);
                ans.deleteCharAt(ans.length() - 1);
                marked[i] = false;
            }
        }
    }
}
