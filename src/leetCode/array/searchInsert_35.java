package leetCode.array;

import java.util.Arrays;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 */
public class searchInsert_35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        int temp = searchInsert2(nums,7);
        System.out.println(temp);
    }
    //method one:
    public static int searchInsert(int[] nums, int target) {
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == target){
                return i;
            }
        }
        //如果数组中没有匹配的数字，就将target加入比原数组多一个位置的临时数组中，并排序，这样来得到它的位置
        int[] nums2 = new int[nums.length+1];
        for (int i = 0;i < nums.length;i++) {
            nums2[i] = nums[i];
        }
        nums2[nums2.length-1] = target;
        Arrays.sort(nums2);
        int temp = 0;
        for(int i = 0;i < nums2.length;i++){
            if(nums2[i] == target) temp = i;
        }
        return temp;
    }
    //显然方式2的思路更加简洁，在一次大的循环中依次完成两个判断，用tempIndex临时变量来记录下标，循环结束后返回临时变量即可
    //method two :
    public static int searchInsert2(int[] nums,int target){
        int tempIndex = 0;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] == target) {
                tempIndex = i;
                break;
            }
            if (nums[i] < target) {
                tempIndex = i+1;
            }
        }
        return tempIndex;
    }
}
