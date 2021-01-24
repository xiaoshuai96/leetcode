package leetCode.array;

import java.util.Stack;

/**
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，
 * 都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1],
 * nums[r]] 就是连续递增子序列。
 *
 * 示例 1：
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 *
 * 示例 2：
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 *
 * 提示：
 *     0 <= nums.length <= 104
 *     -109 <= nums[i] <= 109
 */
public class findLengthOfLCIS_674 {
    public static void main(String[] args) {
        int[] nums = {2,1,3};
        new findLengthOfLCIS_674().findLengthOfLCIS(nums);
    }

    /**
     * 单调栈
     * 执行用时：9 ms, 在所有 Java 提交中击败了5.90% 的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了93.38% 的用户
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int count = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        for (int i = 0; i < nums.length; i++) {
            if (stack.peek() < nums[i]) {
                stack.push(nums[i]);
            } else {
                while (!stack.isEmpty()) {
                    stack.pop();
                }
                stack.push(nums[i]);
            }
            count = Math.max(count,stack.size());
        }
        return count;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.83% 的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了14.36% 的用户
     * @param nums
     * @return
     */
    public int findLengthOfLCIS02(int[] nums){
        if (nums.length < 2) {
            return nums.length;
        }
        int max = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                max = Math.max(count,max);
                count = 1;
            }
        }
        return Math.max(max, count);
    }
}
