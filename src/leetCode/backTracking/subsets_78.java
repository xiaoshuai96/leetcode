package leetCode.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class subsets_78 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new subsets_78().subsets(new int[]{1,2,3});
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了95.49% 的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了60.75% 的用户
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backTrack(res,new LinkedList<Integer>(),nums,0);
        return res;
    }
    private void backTrack(List<List<Integer>> res, LinkedList<Integer> ans, int[] nums, int k){
        res.add(new ArrayList<Integer>(ans));
        for (int i = k; i < nums.length; i++) {
            ans.addLast(nums[i]);
            backTrack(res, ans, nums, i + 1);
            ans.removeLast();
        }
    }
}
