package leetCode.dynamicProgramming;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *

 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 *
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 *
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 */
public class massage_interview_17_16 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :36.5 MB, 在所有 Java 提交中击败了100.00%的用户
     * 
     * 动态规划：dp[i]代表的是第i-1个号预约之前的最高时长
     * 先初始化dp前两个元素，因为要求出当前的最高预约时长，需要前两个元素的值
     * dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i])
     * @param nums
     * @return
     */
    public static int massage01(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[1];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            dp[n] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }

    /**
     * 对01版本的优化，因为每次求出当前值只需要前两个元素的值，所以我们只需要设置两个临时变量a,b
     * a代表的是
     * @param nums
     * @return
     */
    public static int massage02(int[] nums){
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前dp[i],b代表dp[i-1],a代表dp[i-2]，求出dp[i]之后，将a、b当前的值进行更新
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
}
