package leetCode.dynamicProgramming;
/**
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 *
 *
 * 示例 1：
 *
 * 输入：values = [8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 * 示例 2：
 *
 * 输入：values = [1,2]
 * 输出：2
 *
 *
 *
 * 提示：
 *     2 <= values.length <= 5 * 10^4
 *     1 <= values[i] <= 1000
 */
public class maxScoreSightseeingPair_1014 {
    /**
     * 实际上 values[i] + values[j] + i - j 这个表达式可以写成(values[i] + i) + (values[j] - j)
     * 我们可以在一次循环中同时更新两个部分
     * 首先ans代表的就是当前循环中的最高分，然后mx代表的是values[i] + i，我们一直更新让它保持在最大值
     * 然后在遍历values[j] - j的时候就可以得到整体的最大值
     * @param nums
     * @return
     */
    public int maxScoreSightseeingPair(int[] nums) {
        int n = nums.length;
        //max = nums[i] + i
        int ans = 0, mx = nums[0] + 0;
        for (int j = 1; j < n; ++j) {
            ans = Math.max(ans, mx + nums[j] - j);
            //更新max
            mx = Math.max(mx, nums[j] + j);
        }
        return ans;

    }
}
