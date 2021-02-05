package leetCode.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例：
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 * 提示：
 *     1 <= k <= n <= 30,000。
 *     所给数据范围 [-10,000，10,000]。
 */
public class findMaxAverage_643 {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {1,12,-5,-6,50,3};
        double v = new findMaxAverage_643().findMaxAverage(nums, k);
        System.out.println(v);
    }

    /**
     * 执行用时：20 ms, 在所有 Java 提交中击败了13.83% 的用户
     * 内存消耗：45.6 MB, 在所有 Java 提交中击败了5.10% 的用户
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length,i = 0;
        double res = -10000;
        double sum = 0;
        Deque<Integer> deque = new LinkedList<>();
        while (i < len) {
            if (deque.size() < k) {
                sum += nums[i];
                deque.addLast(nums[i]);
                i++;
            } else {
                res = Math.max(res, sum / k);
                Integer head = deque.pollFirst();
                sum -= head;
            }
        }
        return Math.max(res, sum / k);
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了43.04% 的用户
     * 内存消耗：42.8 MB, 在所有 Java 提交中击败了32.68% 的用户
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage02(int[] nums, int k) {
        // 滑动窗口
        double maxValueAvg = Integer.MIN_VALUE;
        double tempSum = 0.0;
        int n = nums.length;
        int left = 0, right = 0;
        while (right < n) {
            tempSum += nums[right];
            right++;
            if (right - left == k) {
                // System.out.println("left + right tempSum " + left + " " + right + " " + tempSum);
                maxValueAvg = Math.max(maxValueAvg, tempSum * 1.0 / k);
                tempSum -= nums[left];
                left++;
            }
        }
        return maxValueAvg;
    }

}
