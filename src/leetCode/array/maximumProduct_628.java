package leetCode.array;

import java.util.Arrays;
/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: 6
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: 24
 *
 * 注意:
 *     给定的整型数组长度范围是[3,10^4]，数组中所有的元素范围是[-1000, 1000]。
 *     输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */
public class maximumProduct_628 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：14 ms, 在所有 Java 提交中击败了9.08% 的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了22.85% 的用户
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int res = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                count++;
            } else {
                break;
            }
        }
        if (count >= 2) {
            return Math.max(res,nums[0] * nums[1] * nums[len - 1]);
        }
        return res;
    }

    /**
     * 执行用时：12 ms, 在所有 Java 提交中击败了69.60% 的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了12.68% 的用户
     * @param nums
     * @return
     */
    public int maximumProduct02(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int res = nums[len - 1] * nums[len - 2] * nums[len - 3];
        return Math.max(res,nums[0] * nums[1] * nums[len - 1]);

    }
}
