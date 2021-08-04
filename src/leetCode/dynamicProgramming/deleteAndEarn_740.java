package leetCode.dynamicProgramming;
/**
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 *
 * 示例 1：
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 *
 * 示例 2：
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *
 * 提示：
 *     1 <= nums.length <= 2 * 10^4
 *     1 <= nums[i] <= 10^4
 */
public class deleteAndEarn_740 {
    /**
     * 实际上，本题是“打家劫舍”题目的变形
     * 例如，对于数组[2,2,3,3,3,4]而言，如果我们选择了2，那么元素3会被删除，等到选择下一个2的时候，已经没有2+1和2-1的数字了。
     * 这时，只需要把2这个值累加即可，那我们可以统计出数组中每个数字的个数
     * [0,0,2,3,1]
     * 上面的数组代表的是在数组i位置上，数字i在nums中的个数
     * 这个时候题目就变成了“打家劫舍”了~
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int maxNum = 0;
        //get maxinum number
        for (int i = 0; i < n; i++) maxNum = Math.max(maxNum, nums[i]);
        int[] all = new int[maxNum + 1];
        //set value to new array
        for (int i : nums) all[i] += i;
        int first = all[0], second = Math.max(all[0], all[1]);
        for (int i = 2; i < all.length; i++) {
            int temp = second;
            second = Math.max(first + all[i], second);
            first = temp;
        }
        return second;
    }
}
