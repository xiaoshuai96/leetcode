package leetCode.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 *
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 提示：
 *
 *     1 <= nums.length <= 10^5
 *     -10^4 <= nums[i] <= 10^4
 *     1 <= k <= nums.length
 */
public class maxSlidingWindow_239 {
    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        queue.addLast(4);
        queue.addFirst(5);
        System.out.println(queue.pop());
    }

    /**
     * 执行用时：30 ms, 在所有 Java 提交中击败了60.61% 的用户
     * 内存消耗：47.7 MB, 在所有 Java 提交中击败了97.37% 的用户
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
        LinkedList<Integer> list = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 如果数组当前数大于队列最前面的数（也就是大于队列中的所有数） 弹出队列中的所有数字
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]) {
                list.pollLast();
            }
            // 添加当前值对应的数组下标
            list.addLast(i);
            // 初始化窗口 等到窗口长度为k时 下次移动在删除过期数值
            if (list.peek() <= i - k) {
                list.poll();
            }
            // 窗口长度为k时 取最顶端数字放入结果数组中
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[list.peek()];
            }
        }
        return result;
    }

    /**
     * 执行用时：34 ms, 在所有 Java 提交中击败了42.12% 的用户
     * 内存消耗：48.1 MB, 在所有 Java 提交中击败了87.50% 的用户
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow02(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peek() <= i - k) {
                queue.poll();
            }

            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[queue.peek()];
            }
        }
        return res;
    }
}
