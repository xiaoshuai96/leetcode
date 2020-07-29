package leetCode.BitManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。
 * 找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,3,2]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 */
public class singleNumber_137 {
    public static void main(String[] args) {
        int i = singleNumber(new int[]{2, 2, 3, 2});
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了23.57% 的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了14.29% 的用户
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) == 1) return i;
        }
        return -1;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.8 MB, 在所有 Java 提交中击败了14.29% 的用户
     * @param nums
     * @return
     */
    public static int singleNumber02(int[] nums){
        int seenOnce = 0, seenTwice = 0;
        for (int num : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        return seenOnce;
    }
}
