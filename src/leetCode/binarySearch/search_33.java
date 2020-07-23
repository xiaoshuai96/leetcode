package leetCode.binarySearch;

import com.sun.javafx.image.BytePixelSetter;

import java.lang.annotation.ElementType;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class search_33 {
    public static void main(String[] args) {
        int search = search(new int[]{1,3}, 3);
        System.out.println(search);
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了17.74% 的用户
     *
     *
     * 数组经过一次旋转之后，一定将数组分成了两个有序的部分
     * 中间下标是mid
     * 1.如果l,mid是有序数组，且target满足 nums[l] =< target <= nums[mid]，那么就在左半部分查找，否则
     * 就去mid+1,r中查找
     * 2.如果mid+1，r是有序数组，且target满足 nums[mid+1] =< target <= nums[r]，那么就在右半部分查找，否则
     * 就去1,mid中查找
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums,int target){
        int left = 0,len = nums.length,right = len - 1;
        if (len == 0) return -1;
        if (len == 1) return (nums[0] == target) ? 0 : -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left  = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left  = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
