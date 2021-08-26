package leetCode.twoPointers;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，
 * 所有偶数位于数组的后半部分。
 *
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 提示：
 *
 *     1 <= nums.length <= 50000
 *     1 <= nums[i] <= 10000
 */
public class exchange_Offer_21 {
    public static void main(String[] args) {
        int[] arr = {2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};

    }

    /**
     * 站在今天的角度看当时写的代码，实在是太拉了~
     * 执行用时：3 ms, 在所有 Java 提交中击败了35.18% 的用户
     * 内存消耗：47.8 MB, 在所有 Java 提交中击败了54.61% 的用户
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums){
        int left = 0,right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 0 && nums[right] % 2 == 1) {
                change(left,right,nums);
                left++;
                right--;
            } else if (nums[left] % 2 == 1 && nums[right] % 2 == 1) {
                left++;
            } else if (nums[left] % 2 == 0 && nums[right] % 2 == 0) {
                right--;
            } else if (nums[left] % 2 == 1 && nums[right] % 2 == 0) {
                left++;
                right--;
            }
        }
        return nums;
    }
    private void change(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 双指针：一个在最前面、一个在最后面，两个小循环分别找到偶数和奇数，然后进行交换
     * @param nums
     * @return
     */
    public int[] exchange02(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }

    /**
     * fast & slow pointer
     * @param nums
     * @return
     */
    public int[] exchange03(int[] nums){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果当前元素是奇数，那么就交换i位置的元素和count位置的元素
            //然后再使用count记录i的下一个位置
            if (nums[i] % 2 == 1) {
                change(i,count,nums);
                count++;
            }
        }
        return nums;
    }
}
