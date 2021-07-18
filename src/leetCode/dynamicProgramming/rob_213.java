package leetCode.dynamicProgramming;
/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 *
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 *
 * 提示：
 *     1 <= nums.length <= 100
 *     0 <= nums[i] <= 1000
 */
public class rob_213 {
    /**
     * 本题和198题的主要区别就在于，前后两个房屋变成了相邻的
     * 这个问题可以转化成两个子问题：
     * 1.从第一间房到n-1间房的范围中，能够偷窃的最大金额；
     * 2.从第二间房到n间房的范围中，能够偷窃的最大金额；
     *
     * 取两个子问题结果的最大值，即是该题的解
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 1) return n;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robRange(0, n - 2, nums), robRange(1, n - 1, nums));

    }
    public int robRange(int start,int end ,int[] nums){
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
