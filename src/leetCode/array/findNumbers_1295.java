package leetCode.array;

/**
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 *
 * 示例 1：
 *
 * 输入：nums = [12,345,2,6,7896]
 * 输出：2
 * 解释：
 * 12 是 2 位数字（位数为偶数）
 * 345 是 3 位数字（位数为奇数）
 * 2 是 1 位数字（位数为奇数）
 * 6 是 1 位数字 位数为奇数）
 * 7896 是 4 位数字（位数为偶数）
 * 因此只有 12 和 7896 是位数为偶数的数字
 *
 * 示例 2：
 *
 * 输入：nums = [555,901,482,1771]
 * 输出：1
 * 解释：
 * 只有 1771 是位数为偶数的数字。
 * 提示：
 *
 *     1 <= nums.length <= 500
 *     1 <= nums[i] <= 10^5
 *
 */
public class findNumbers_1295 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时 :12 ms, 在所有 Java 提交中击败了5.61% 的用户
     * 内存消耗 :40.7 MB, 在所有 Java 提交中击败了5.09%的用户
     * @param nums
     * @return
     */
    public static int findNumbers(int[] nums){
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            if((nums[i]+"").length() % 2 == 0){
                res++;
            }
        }
        return res;
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.93% 的用户
     * 内存消耗 :38.6 MB, 在所有 Java 提交中击败了36.33%的用户
     * @param nums
     * @return
     */
    public static int findNumbers02(int[] nums){
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            if ((nums[i] >= 10)&&(nums[i] <= 99) || (nums[i] >= 1000)&&(nums[i] <= 9999)) {
                res++;
            }
        }
        return res;
    }
}
