package leetCode.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。
 * 每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，
 * 较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。
 * 当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
 * 返回赢得比赛的整数。
 * 题目数据 保证 游戏存在赢家。
 *
 *
 * 示例 1：
 * 输入：arr = [2,1,3,5,4,6,7], k = 2
 * 输出：5
 * 解释：一起看一下本场游戏每回合的情况：
 *
 * 因此将进行 4 回合比赛，其中 5 是赢家，因为它连胜 2 回合。
 *
 * 示例 2：
 * 输入：arr = [3,2,1], k = 10
 * 输出：3
 * 解释：3 将会在前 10 个回合中连续获胜。
 *
 * 示例 3：
 * 输入：arr = [1,9,8,2,3,7,6,4,5], k = 7
 * 输出：9
 *
 * 示例 4：
 * 输入：arr = [1,11,22,33,44,55,66,77,88,99], k = 1000000000
 * 输出：99
 *
 *
 * 提示：
 *     2 <= arr.length <= 10^5
 *     1 <= arr[i] <= 10^6
 *     arr 所含的整数 各不相同 。
 *     1 <= k <= 10^9
 */
public class getWinner_1535 {
    public static void main(String[] args) {
        int[] arr = {1,9,8,2,3,7,6,4,5};
        int winner = new getWinner_1535().getWinner(arr, 7);
        System.out.println(winner);
    }

    /**
     * 暴力模拟
     * 执行用时：22 ms, 在所有 Java 提交中击败了12.28% 的用户
     * 内存消耗：55.2 MB, 在所有 Java 提交中击败了5.11% 的用户
     * @param arr
     * @param k
     * @return
     */
    public int getWinner(int[] arr, int k) {
        //如果连胜次数k大于等于数组的长度，即数组中最大值为最终获胜的赢家
        if (k >= arr.length) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
            }
            return max;
        }
        //模拟对抗
        Deque<Integer> deque = new LinkedList<>();
        for (int i : arr) deque.add(i);
        int curr = 0,count = 0;
        while (count < k) {
            Integer arr0 = deque.pollFirst();
            Integer arr1 = deque.pollFirst();
            int max = arr0 > arr1 ? arr0 : arr1;
            int min = arr0 < arr1 ? arr0 : arr1;
            deque.addFirst(max);
            deque.addLast(min);
            if (curr == max) {
                count++;
            } else {
                curr = max;
                count = 1;
            }
        }
        return curr;
    }


    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：50.2 MB, 在所有 Java 提交中击败了20.33% 的用户
     * 算法思路：
     * 其实是不用移动数组中的元素的，因为赢家一定存在，所以我们只需要遍历一次数组
     * @param arr
     * @param k
     * @return
     */
    public int getWinner02(int[] arr, int k) {
        int prev = Math.max(arr[0], arr[1]);
        if (k == 1) {
            return prev;
        }
        int consecutive = 1;
        int maxNum = prev;
        int length = arr.length;
        for (int i = 2; i < length; i++) {
            int curr = arr[i];
            if (prev > curr) {
                consecutive++;
                if (consecutive == k) {
                    return prev;
                }
            } else {
                prev = curr;
                consecutive = 1;
            }
            maxNum = Math.max(maxNum, curr);
        }
        return maxNum;
    }
}
