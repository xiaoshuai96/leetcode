package leetCode.binarySearch;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 *
 * 提示：
 *     你可以假设 nums 中的所有元素是不重复的。
 *     n 将在 [1, 10000]之间。
 *     nums 的每个元素都将在 [-9999, 9999]之间。
 *
 */
public class search_704 {
    public static void main(String[] args) {

    }

    /**
     * iterator
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了49.56% 的用户
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left  = mid + 1;
            }
        }
        return -1;
    }

    /**
     * recursion
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了96.56% 的用户
     */
    int count = 0;
    public int search02(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target?0:-1;
        }
        return helper(nums,target,0,nums.length);
    }
    public int helper(int[] nums,int target,int left,int right){
        if (count > nums.length/2+1) return -1;
        int middle = (left+right)/2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] > target) {//往左找
            count+=1;
            return helper(nums, target, left, middle);
        } else if (nums[middle] < target) {//往右找
            count+=1;
            return helper(nums, target, middle, nums.length);
        }
        return -1;
    }
}
