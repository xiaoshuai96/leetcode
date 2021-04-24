package leetCode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 *
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class containsNearbyDuplicate_219 {
    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了74.14% 的用户
     * 内存消耗：44.7 MB, 在所有 Java 提交中击败了5.03% 的用户
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            Integer val = map.get(nums[i]);
            if (val == null) {
                map.put(nums[i], i);
            } else {
                if (Math.abs(val - i) <= k) {
                    return true;
                }
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
