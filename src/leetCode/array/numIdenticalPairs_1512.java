package leetCode.array;

/**
 * 给你一个整数数组 nums 。
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * 返回好数对的数目。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 *
 * 示例 2：
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 *
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：0
 *
 *
 *
 * 提示：
 *     1 <= nums.length <= 100
 *     1 <= nums[i] <= 100
 */
public class numIdenticalPairs_1512 {
    public static void main(String[] args) {

    }

    /**
     * 看到提示中的数组的最大长度，果断先来暴力求解
     * 执行用时：1 ms, 在所有 Java 提交中击败了83.38% 的用户
     * 内存消耗：36.9 MB, 在所有 Java 提交中击败了100.00% 的用户
     * @param nums
     * @return
     */
    public static int numIdenticalPairs01(int[] nums){
        int res = 0;
        for(int i = 0;i < nums.length - 1;i++){
            for(int j = i + 1;j < nums.length;j++){
                if(nums[i] == nums[j]){
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 技巧求解
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.9 MB, 在所有 Java 提交中击败了100.00% 的用户
     * @param nums
     * @return
     */
    public static int numIdenticalPairs02(int[] nums){
        int res = 0;
        int[] count = new int[101];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0 || count[i] != 1) {
                res += (count[i]*(count[i] - 1) / 2);
            }
        }
        return res;
    }
}
