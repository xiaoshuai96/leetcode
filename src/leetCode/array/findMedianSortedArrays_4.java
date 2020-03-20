package leetCode.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 */
public class findMedianSortedArrays_4 {
    public static void main(String[] args){
        int[] arr1 = {1,2};
        int[] arr2 = {3,4};
        double d = findMedianSortedArrays(arr1,arr2);
        System.out.println(d);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //记录两个数组的总长度
        int bothLength = nums1.length+nums2.length;
        int[] sum = new int[bothLength];
        double median = 0;
        //现在新的数组中将nums1中的元素加入
        for (int i = 0;i < nums1.length;i++) {
            sum[i] = nums1[i];
        }
        //将nums2中的元素加入新数组中空余的位置
        for (int j = nums1.length,p = 0;j < bothLength;j++,p++){
            sum[j] = nums2[p];
        }
        //对新数组进行排序
        Arrays.sort(sum);

        //根据数组中元素的奇偶来确定median的值
        if (sum.length%2==1) {
            median = sum[sum.length/2];
        }else{
            median = ((double)sum[sum.length/2-1]+(double)sum[sum.length/2])/2;
        }
        return median;
    }
}
