package leetCode.twoPointers;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 *
 *     必须在原数组上操作，不能拷贝额外的数组。
 *     尽量减少操作次数。
 *
 */
public class moveZeroes_283 {
    public static void main(String[] args) {
        int[] nums = {1,0};
        moveZeroes01(nums);
        System.out.println(Arrays.toString(nums));
    }

    //version 1.0 这冗余的代码，看着头大
    public static void moveZeroes01(int[] nums){
        int head = 0,last = 1;
        //截止条件
        while (last < nums.length) {
            //head找到等于0的数
            while (head < nums.length) {
                if (nums[head] == 0) break;
                head++;
                if (head == nums.length) return;
            }
            if (head+1 == nums.length) break;
            last = head + 1;
            //last找到不等于0的数
            while (last < nums.length) {
                if (nums[last] != 0) break;
                last++;
                if (last == nums.length) return;
            }
            //exchange
            nums[head] = nums[head] ^ nums[last];
            nums[last] = nums[head] ^ nums[last];
            nums[head] = nums[head] ^ nums[last];
            last++;
        }
    }

    /**
     * version 2.0
     * 思路：第一次循环将非0的数往左边挪，第二次数将剩余的空全补成0；
     * @param nums
     */
    public static void moveZeroes02(int[] nums){
        if (nums == null) return ;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[temp++] = nums[i];
            }
        }
        for (int i = temp;i < nums.length; i++) nums[i] = 0;
    }

    //version 2.1  twoPointers
    public static void moveZeroes(int[] nums){
        if (nums == null) return;
        int i = 0, j = 0;
        for (;i < nums.length;i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}
