package leetCode.dynamicProgramming;
/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class maxProduct_152 {
    /**
     * 定义二维数组dp[i][j]
     * i位置代表以nums[i]结尾的最值
     * j位置有两个状态0和1
     * 0代表最小值
     * 1代表最大值
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] >= 0) {
                //如果当前值是正数
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
            } else {
                //如果当前值是负数，那么乘以前一个值结尾的最大值即为最小值，乘以前一个值结尾的最小值即为最大值
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
            }
        }
        //遍历出最大值
        int max = dp[0][1];
        for (int i = 1; i < n; i++) {
            max = Math.max(dp[i][1], max);
        }
        return max;
    }
}
