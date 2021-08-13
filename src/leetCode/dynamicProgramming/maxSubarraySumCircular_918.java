package leetCode.dynamicProgramming;
/**
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）
 * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
 *
 *
 * 示例 1：
 * 输入：[1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 *
 * 示例 2：
 * 输入：[5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 *
 * 示例 3：
 * 输入：[3,-1,2,-1]
 * 输出：4
 * 解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
 *
 * 示例 4：
 * 输入：[3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 *
 * 示例 5：
 * 输入：[-2,-3,-1]
 * 输出：-1
 * 解释：从子数组 [-1] 得到最大和 -1
 *
 *
 * 提示：
 *     -30000 <= A[i] <= 30000
 *     1 <= A.length <= 30000
 */
public class maxSubarraySumCircular_918 {

    /**
     *
     * ‘*’在数组中代表的就是目标子数组的一个元素
     * 该题与53题的区别就在于是否是环形数组
     * 1.不用环 [1,2,*,*,*,*,1,9]
     *  结果直接就是53题的题解的答案
     * 2.用环 [*,*,*,3,4,1,-2,7,*,*,*]
     *  我们只要求出元素3,4,1,-2,7中最小的序列和，然后用数组的总和-这个最小值，即得到了最大值
     *
     *  再与不用环的结果进行比较，取最大值即可
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int sum = nums[0];
        int max = nums[0];

        //先求出数组的最大子序和
        for (int i = 1; i < nums.length; ++i) {
            sum += nums[i];
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }

        int min = 0;
        //紧接着求出数组的[2,n - 2]之间的最小序列和
        for (int i = 1; i < nums.length - 1; ++i) {
            dp[i] = Math.min(dp[i - 1] + nums[i], nums[i]);
            min = Math.min(dp[i], min);
        }

        return Math.max(sum - min, max);
    }
}
