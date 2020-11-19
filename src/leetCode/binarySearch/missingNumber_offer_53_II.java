package leetCode.binarySearch;
/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 */
public class missingNumber_offer_53_II {
    public static void main(String[] args) {

    }

    /**
     * 如果该数组中的中间元素和它自身的下标值是一样的，那说明数组的前半部分是符合条件的
     * 那么我们直接往右半部分数组遍历
     * 一直到left > right时，这时left表示的就是缺失的数字
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int left = 0,right = nums.length - 1;
        while (left <= right) {
            int m = (left + right) / 2;
            if (nums[m] == m) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return left;

    }

}
