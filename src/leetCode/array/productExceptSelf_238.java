package leetCode.array;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i]
 * 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class productExceptSelf_238 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] ints = new productExceptSelf_238().productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了60.91% 的用户
     * 内存消耗：48.7 MB, 在所有 Java 提交中击败了86.82% 的用户
     * 算法思路：我们需要求的是除过当前元素的所有元素的乘积，即也就是当前元素的所有前缀元素和后缀元素之积
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public int[] productExceptSelf01(int[] nums){
        int len = nums.length;
        int[] L = new int[len];//前缀
        int[] R = new int[len];//后缀
        for (int i = 0; i < len; i++) {
            if (i == 0) L[i] = 1;
            else L[i] = nums[i - 1] * L[i - 1];
        }
        for (int j = len - 1; j >= 0; j--) {
            if (j == len - 1) R[j] = 1;
            else R[j] = nums[j + 1] * R[j + 1];
        }
        for (int k = 0; k < len; k++) {
            nums[k] = L[k] * R[k];
        }
        return nums;
    }


    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了60.91% 的用户
     * 内存消耗：48.8 MB, 在所有 Java 提交中击败了78.11% 的用户
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int p = 1, q = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = p;
            p *= nums[i];
        }
        for (int i = nums.length - 1; i > 0 ; i--) {
            q *= nums[i];
            res[i - 1] *= q;
        }
        return res;
    }


}
