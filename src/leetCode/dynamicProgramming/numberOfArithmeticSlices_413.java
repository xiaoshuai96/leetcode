package leetCode.dynamicProgramming;
/**
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *     例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 *
 *
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：0
 *
 *
 * 提示：
 *     1 <= nums.length <= 5000
 *     -1000 <= nums[i] <= 1000
 */
public class numberOfArithmeticSlices_413 {
    /**
     * DP
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int sum = 0;
        //dp[0] = 0
        int[] dp = new int[n];
        for (int i = 2; i < n; ++i) {
            //如果A,B,C三个数满足B - A = C - B那么即这三个数满足等差数列的定义，依次往后遍历，依然满足的话就在之前的基础上加1
            if ((nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2])) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }

    /**
     * DP空间优化
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices02(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int sum = 0;
        int pre = 0;
        for (int i = 2; i < n; ++i) {
            //如果A,B,C三个数满足B - A = C - B那么即这三个数满足等差数列的定义，依次往后遍历，依然满足的话就在之前的基础上加1
            if ((nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2])) {
                pre = pre + 1;
                sum += pre;
            } else {
                pre = 0;
            }
        }
        return sum;
    }
}
