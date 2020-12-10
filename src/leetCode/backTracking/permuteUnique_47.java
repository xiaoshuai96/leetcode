package leetCode.backTracking;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 提示：
 *     1 <= nums.length <= 8
 *     -10 <= nums[i] <= 10
 */
public class permuteUnique_47 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new permuteUnique_47().permuteUnique(new int[]{1,1,2});
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了65.53% 的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了98.11% 的用户
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len == 0) return res;
        Arrays.sort(nums);
        boolean[] marked = new boolean[nums.length];
        backTrack(res,new LinkedList<Integer>(),nums,marked);
        return res;
    }

    private void backTrack(List<List<Integer>> res, LinkedList<Integer> ans, int[] nums, boolean[] marked) {
        if (ans.size() == nums.length) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !marked[i - 1]) {
                continue;
            }
            if (!marked[i]) {
                marked[i] = true;
                ans.addLast(nums[i]);
                backTrack(res, ans,  nums, marked);
                ans.removeLast();
                marked[i] = false;
            }
        }
    }
}
