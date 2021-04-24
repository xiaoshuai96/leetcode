package leetCode.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 *     所有数字（包括 target）都是正整数。
 *     解集不能包含重复的组合。
 *
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 提示：
 *     1 <= candidates.length <= 30
 *     1 <= candidates[i] <= 200
 *     candidate 中的每个元素都是独一无二的。
 *     1 <= target <= 500
 */
public class combinationSum_39 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new combinationSum_39().combinationSum(new int[]{2,3,5,8},7);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了78.50% 的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了85.48% 的用户
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates.length < 1) return res;
        Arrays.sort(candidates);//排序的目的就是为了加速剪枝
        backTrack(res,new LinkedList<Integer>(),candidates,target,0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, LinkedList<Integer> ans, int[] candidates, int target, int begin) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            ans.addLast(candidates[i]);
            backTrack(res,ans,candidates,target - candidates[i],i);
            ans.removeLast();
        }
    }
}
