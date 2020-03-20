package leetCode.twoPoniters;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用O(1)额外空间的条件下完成。
 *
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class removeDuplicates_26 {
    public static void main(String[] args) {
        int i = removeDuplicates01(new int[]{0,0,1,1,1,2,2,3,3,4});
        System.out.println(i);
    }

    /**
     * 双指针
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.83% 的用户
     * 内存消耗 :41.7 MB, 在所有 Java 提交中击败了7.26%的用户
     * @param nums
     * @return
     */
    public static int removeDuplicates01(int[] nums) {
        int curr = 0,next = 1;
        //一直等next到头
        while (next < nums.length) {
            //当前元素与next上的元素相同，next向后移动，curr不动
            if (nums[curr] == nums[next]) {
                next++;
                continue;
            } else {
                //找到之后开始赋值，两个指针同时挪动
                nums[curr+1] = nums[next];
                curr++;
                next++;
            }
        }
        return curr+1;
    }
        
}
