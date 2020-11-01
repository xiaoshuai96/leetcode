package leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 限制：
 * 1 <= 数组长度 <= 50000
 */
public class majorityElement_offer_39 {
    public static void main(String[] args) {
        int i = majorityElement02(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
        System.out.println(i);
    }
    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了70.15% 的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了95.48% 的用户
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums){
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len / 2];
    }

    //摩尔投票法

    /**
     * 执行用时：1708 ms, 在所有 Java 提交中击败了5.12% 的用户
     * 内存消耗：44.3 MB, 在所有 Java 提交中击败了5.02% 的用户
     * @param nums
     * @return
     */
    public static int majorityElement02(int[] nums){
        List<Integer> list = new ArrayList<>();
        for (int i = 1;i < nums.length ;i++){
            if (list.isEmpty() || list.contains(nums[i])) {
                list.add(nums[i]);
            } else {
                list.remove(0);
            }
        }
        return list.get(0);
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.94% 的用户
     * 内存消耗：41.9 MB, 在所有 Java 提交中击败了70.79% 的用户
     * @param nums
     * @return
     */
    public static int majorityElement03(int[] nums){
        //初始时，假设众数是0，票数为0
        int iff = 0,count = 0;
        for (int i : nums) {
            if (count == 0) {
                iff = nums[i];
            }
            count += iff == nums[i] ? 1 : -1;
        }
        /**
         * 题目中已经说明了该数一定存在
         * 如果最终留下的iff在数组nums中出现的次数超过数组大小的一半的话，说明该数存在，
         * 否则，不存在
         */
        return iff;
    }
}
