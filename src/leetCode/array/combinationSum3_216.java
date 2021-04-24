package leetCode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 *     所有数字都是正整数。
 *     解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 *
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class combinationSum3_216 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new combinationSum3_216().combinationSum3(2, 12);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了50.80% 的用户
     * 内存消耗：36.3 MB, 在所有 Java 提交中击败了25.74% 的用户
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        int target = n;
        List<List<Integer>> res = new ArrayList<>();
        if (k < 1) return res;
        if (n > 9) n = 9;
        int[] nums = new int[n];
        //initialization
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        boolean[] marked = new boolean[n];
        backTracking(res, new LinkedList<>(), nums, k, target, marked, 0);
        return res;
    }
    private void backTracking(List<List<Integer>> res, LinkedList<Integer> ans,int[] nums,int k,int target,boolean[] marked,int begin){
        if (ans.size() > k) {
            return ;
        }
        if (ans.size() == k && target == 0) {
            res.add(new ArrayList<>(ans));
            return ;
        }
        for (int i = begin; i < nums.length; i++) {
            if (target - nums[i] < 0) {
                break;
            }
            if (!marked[i]) {
                marked[i] = true;
                ans.addLast(nums[i]);
                backTracking(res, ans, nums, k, target - nums[i], marked, i + 1);
                ans.removeLast();
                marked[i] = false;
            }
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> ans = new LinkedList<>();
    public List<List<Integer>> combinationSum3II(int k, int n) {
        dfs(1, 9, k, n);
        return res;
    }
    private void dfs(int left,int right,int k,int sum){
        if (ans.size() == k && sum == 0) {
            res.add(new ArrayList<>(ans));
            return ;
        }
        for (int i = left; i <= right; i++) {
            if (sum - i < 0) {
                break;
            }
            ans.addLast(i);
            dfs(left + 1,right,k,sum - i);
            ans.removeLast();
        }
    }
}
