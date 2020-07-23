package leetCode.binarySearch;

import java.math.BigDecimal;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class findMin_153 {
    public static void main(String[] args) {

    }

    /**
     * 暴力法：全局遍历数组找出最小值
     * @param nums
     * @return
     */
    public static int findMin(int[] nums){
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (res > nums[i]) {
                res = nums[i];
            }
        }
        return res;
    }

    /**
     * binarySearch
     * 判断数组是否旋转：
     * 1.数组第一个元素小于数组最后一个元素，证明没有旋转，直接返回数组第一个元素即可
     * 2.否则为旋转数组
     * @param numbers
     * @return
     */
    public static int findMin02(int[] numbers){
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right -= 1;
            }
        }
        return numbers[left];
    }
}
