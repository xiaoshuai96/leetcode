package leetCode.greedy;
/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 */
public class maxSubArray_53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了98.77% 的用户
     * 内存消耗 :41.6 MB, 在所有 Java 提交中击败了8.05%的用户
     * @param nums
     * @return
     */
    //greedy
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = nums[0],maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            currSum = Math.max(nums[i],currSum+nums[i]);
            maxSum = Math.max(currSum,maxSum);
        }
        return maxSum;
    }
}
