package leetCode.array;

import java.util.Arrays;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 示例 1:
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 *
 * 示例 2:
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 *
 * 说明:
 *     你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 *     请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 */
public class maximumGap_164 {
    public static void main(String[] args) {
        int[] nums = {3,6,7,5,1,2,12,56,55,13,56,45};
        new maximumGap_164().maximumGap02(nums);
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.72% 的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了56.98% 的用户
     *
     * 很明显这是非常常规的做法 毫无难度
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res,nums[i] - nums[i - 1]);
        }
        return res;
    }

    /**
     * 基数排序
     * @param nums
     * @return
     */
    public int maximumGap02(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        long exp = 1;
        int[] buf = new int[n];
        //拿到数组中的最大值
        int maxVal = Arrays.stream(nums).max().getAsInt();

        /**
         * 3,6,7,5,1,2,12,56,55,13,56,45
         */
        while (maxVal >= exp) {
            int[] cnt = new int[10];
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / (int) exp) % 10;
                cnt[digit]++;
            }
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            System.arraycopy(buf, 0, nums, 0, n);
            exp *= 10;
        }

        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }
}
