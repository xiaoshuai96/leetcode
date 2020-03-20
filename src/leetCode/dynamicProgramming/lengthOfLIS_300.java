package leetCode.dynamicProgramming;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 *
 *     可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 *     你算法的时间复杂度应该为 O(n2) 。
 *
 */
public class lengthOfLIS_300 {
    public static void main(String[] args) {
        lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }

    /**
     * 动态规划
     * 时间复杂度：O(n^2)
     * 执行用时 :13 ms, 在所有 Java 提交中击败了61.75% 的用户
     * 内存消耗 :37.2 MB, 在所有 Java 提交中击败了6.35%的用户
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums){
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
