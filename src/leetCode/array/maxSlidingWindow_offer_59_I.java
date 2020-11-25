package leetCode.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

 示例:

 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 输出: [3,3,5,5,6,7]
 解释:

 滑动窗口的位置                最大值
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7



 提示：

 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 */
public class maxSlidingWindow_offer_59_I {
    public static void main(String[] args) {
        int[] arr = new int[]{1};
        System.out.println(Arrays.toString(maxSlidingWindow(arr,1)));
    }

    /**
     * 执行用时：40 ms, 在所有 Java 提交中击败了12.57% 的用户
     * 内存消耗：46.3 MB, 在所有 Java 提交中击败了89.97% 的用户
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return nums;
        int len = nums.length - k + 1;
        int[] res = new int[len];
        for (int i = 0; (i + k - 1) < nums.length; i++) {
            res[i] = getMaxFromNumbers(nums,i,k + i - 1);
        }
        return res;
    }
    private static int getMaxFromNumbers(int[] nums,int start,int end) {
        int res = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            res = Math.max(nums[i], res);
        }
        return res;
    }

    /**
     * 执行用时：14 ms, 在所有 Java 提交中击败了74.71% 的用户
     * 内存消耗：47.2 MB, 在所有 Java 提交中击败了47.52% 的用户
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow02(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++) { // 未形成窗口
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for(int i = k; i < nums.length; i++) { // 形成窗口后
            if(deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
