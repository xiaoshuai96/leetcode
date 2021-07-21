package leetCode.dynamicProgramming;
/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 *
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 *
 * 示例 5：
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 *
 * 提示：
 *     1 <= nums.length <= 3 * 104
 *     -105 <= nums[i] <= 105
 */
public class maxSubArray_53 {
    /**
     * 设状态dp[i]为以下标i为最后一个数字的子数组中最大子序和
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1;i < n;++i){
            dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }

    /**
     * 空间复杂度优化为O(1)
     * @param nums
     * @return
     */
    public int maxSubArray02(int[] nums){
        int pre = nums[0],max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }
}
