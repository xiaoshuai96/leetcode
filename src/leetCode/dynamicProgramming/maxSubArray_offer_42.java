package leetCode.dynamicProgramming;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 */
public class maxSubArray_offer_42 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.05% 的用户
     * 内存消耗：46.4 MB, 在所有 Java 提交中击败了100.00% 的用户
     * @param nums
     * @return
     */
    public static int maxSubArray01(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.06%的用户
     * 内存消耗：46.6 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @return
     */
    public static int maxSubArray02(int[] nums) {
        int max = nums[0];
        int former = 0;//用于记录dp[i-1]的值，对于dp[0]而言，其前面的dp[-1]=0
        int cur = nums[0];//用于记录dp[i]的值
        for(int num : nums){
            cur = num;
            if(former > 0) cur += former;
            if(cur > max) max = cur;
            former = cur;
        }
        return max;
    }
}
