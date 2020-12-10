package leetCode.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 *     所有数字（包括目标数）都是正整数。
 *     解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class combinationSum2_40 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new combinationSum2_40().combinationSum2(new int[]{2,5,2,1,2},5);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了87.24% 的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了96.98% 的用户
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates.length < 1) return res;
        boolean[] marked = new boolean[candidates.length];
        Arrays.sort(candidates);//排序的目的就是为了加速剪枝
        backTrack(res,new LinkedList<Integer>(),candidates,target,0,marked);
        return res;
    }

    private void backTrack(List<List<Integer>> res, LinkedList<Integer> ans, int[] candidates, int target, int begin,boolean[] marked) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !marked[i - 1]) {
                continue;
            }
            if (target - candidates[i] < 0) {
                break;
            }
            if (!marked[i]) {
                marked[i] = true;
                ans.addLast(candidates[i]);
                backTrack(res, ans, candidates, target - candidates[i], i + 1, marked);
                ans.removeLast();
                marked[i] = false;
            }
        }
    }
}
