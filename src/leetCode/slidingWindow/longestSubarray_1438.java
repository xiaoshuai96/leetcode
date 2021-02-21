package leetCode.slidingWindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，
 * 该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 *
 * 示例 1：
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 *
 * 示例 2：
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 *
 * 示例 3：
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 *
 *
 * 提示：
 *     1 <= nums.length <= 10^5
 *     1 <= nums[i] <= 10^9
 *     0 <= limit <= 10^9
 */
public class longestSubarray_1438 {
    public static void main(String[] args) {
        int[] nums = {8,2,4,7};
        int i = new longestSubarray_1438().longestSubarray02(nums, 4);
        System.out.println(i);
    }

    /**
     * 暴力解法，超出时间限制
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        int res = 0;
        int max ,min;
        int len = nums.length;
        int left = 0,right = 0;
        while (left < len) {
            max = nums[left];
            min = nums[left];
            while(right < len){
                //在局部子数组中求出绝对值差
                max = Math.max(max,nums[right]);
                min = Math.min(min,nums[right]);
                if((max - min) <= limit) res = Math.max(res,right - left + 1);
                right++;
            }
            ++left;
            right = left;
        }
        return res;
    }


    public int longestSubarray02(int[] nums, int limit) {
        //维护两个队列，一个用来统计最大值，另一个用来统计最小值
        Deque<Integer> queMax = new LinkedList<Integer>();
        Deque<Integer> queMin = new LinkedList<Integer>();
        int len = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < len) {
            while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                queMax.pollLast();
            }
            while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                queMin.pollLast();
            }
            queMax.offerLast(nums[right]);
            queMin.offerLast(nums[right]);
            while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                if (nums[left] == queMin.peekFirst()) {
                    queMin.pollFirst();
                }
                if (nums[left] == queMax.peekFirst()) {
                    queMax.pollFirst();
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }
}
