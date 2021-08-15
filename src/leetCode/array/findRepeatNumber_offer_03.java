package leetCode.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *
 *
 * 限制：
 *
 * 2 <= n <= 100000
 */
public class findRepeatNumber_offer_03 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了90.16% 的用户
     * 内存消耗：46.2 MB, 在所有 Java 提交中击败了89.34% 的用户
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums){
        int len = nums.length;
        //该数组记录nums中每个数字出现的次数
        int[] arr = new int[len];
        for(int i = 0;i < len;i++){
            arr[nums[i]]++;
        }
        for(int j = 0;j < len;j++){
            //如果那个元素对应的大小超过了1，那么说明j数字出现了不止一次，直接返回即可
            if(arr[j] > 1) return j;
        }
        return -1;//表示没有
    }

    /**
     * 疯狂调API
     *
     * 执行用时：4 ms, 在所有 Java 提交中击败了51.44% 的用户
     * 内存消耗：46.7 MB, 在所有 Java 提交中击败了52.51% 的用户
     * @param nums
     * @return
     */
    public int findRepeatNumber02(int[] nums){
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        for (int i = 0;i < temp.length - 1;i++){
            if (temp[i] == temp[i+1]) return temp[i];
        }
        return -1;
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了49.61% 的用户
     * 内存消耗：48.6 MB, 在所有 Java 提交中击败了13.48% 的用户
     * @param nums
     * @return
     */
    public int findRepeatNumber03(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            //加不进去，说明重叠，直接返回
            if (!set.add(i)) {
                return i;
            }
        }
        return -1;

    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了88.75% 的用户
     * 内存消耗：46 MB, 在所有 Java 提交中击败了93.21% 的用户
     * @param nums
     * @return
     */
    public int findRepeatNumber04(int[] nums) {
        int temp = 0;
        /**
         * 算法思路：一个萝卜一个坑  因为题目中已经告知了这些数字的范围在0~n-1之间
         * 那么如果没有重复的数字，在数组按照递增排序时，每个下标和该位置上的数字应该是
         * 一致的，如果不一致说明该数就是重复的数
         */
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public int findRepeatNumber05(int[] nums){
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]]++;
            if (temp[nums[i]] > 1) return nums[i];
        }
        return -1;
    }
}
