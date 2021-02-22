package leetCode.array;
/**
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 * 请你返回 nums 中唯一元素的 和 。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,2]
 * 输出：4
 * 解释：唯一元素为 [1,3] ，和为 4 。
 *
 * 示例 2：
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：没有唯一元素，和为 0 。
 *
 * 示例 3 ：
 * 输入：nums = [1,2,3,4,5]
 * 输出：15
 * 解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
 *
 * 提示：
 *     1 <= nums.length <= 100
 *     1 <= nums[i] <= 100
 */
public class sumOfUnique_1748 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了30.89% 的用户
     * @param nums
     * @return
     */
    public int sumOfUnique(int[] nums) {
        int res = 0;
        int[] count = new int[101];
        for(int i : nums){
            count[i]++;
        }
        for(int i = 0;i < count.length;i++){
            if(count[i] == 1){
                res += i;
            }
        }
        return res;
    }
}
