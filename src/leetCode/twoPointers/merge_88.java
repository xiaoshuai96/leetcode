package leetCode.twoPointers;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明：
 *     初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 *     你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例：
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出：[1,2,2,3,5,6]
 *
 *
 * 提示：
 *     -10^9 <= nums1[i], nums2[i] <= 10^9
 *     nums1.length == m + n
 *     nums2.length == n
 */
public class merge_88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0,0};
        int[] nums2 = {1,5,6,7};
        new merge_88().merge(nums1,3,nums2,4);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了84.22% 的用户
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1和nums2数组中有效数的最后一个元素
        int p1 = m - 1;
        int p2 = n - 1;
        // nums1数组中预留的n长度的最后一个位置
        int p = m + n - 1;

        // 循环比较，直到其中最少有一个数组的指针遍历完成，循环截止
        while ((p1 >= 0) && (p2 >= 0))
            // 从两个数组大的位置开始比较两个元素
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
