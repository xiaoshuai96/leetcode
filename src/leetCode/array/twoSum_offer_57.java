package leetCode.array;

import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 *
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *
 * 限制：
 *     1 <= nums.length <= 10^5
 *     1 <= nums[i] <= 10^6
 */
public class twoSum_offer_57 {
    public static void main(String[] args) {
        int[] sum = new twoSum_offer_57().twoSum(new int[]{1}, 9);
        System.out.println(Arrays.toString(sum));
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了34.51% 的用户
     * 内存消耗：55.6 MB, 在所有 Java 提交中击败了54.99% 的用户
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) {
            return new int[]{nums[0],0};
        }
        int[] res = new int[2];
        int i = 0,j = nums.length - 1;
        while (i < j) {
            while (nums[i] > target) i++;
            while (nums[i] > target) j++;
            if (nums[i] + nums[j] == target) {
                res[0] = nums[i];
                res[1] = nums[j];
                break;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了97.75% 的用户
     * 内存消耗：55.3 MB, 在所有 Java 提交中击败了88.96% 的用户
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum02(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) i++;
            else if(s > target) j--;
            else return new int[] { nums[i], nums[j] };
        }
        return new int[0];
    }
}
