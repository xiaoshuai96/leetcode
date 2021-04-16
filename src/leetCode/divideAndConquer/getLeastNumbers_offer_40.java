package leetCode.divideAndConquer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *     0 <= k <= arr.length <= 10000
 *     0 <= arr[i] <= 10000
 */
public class getLeastNumbers_offer_40 {
    public static void main(String[] args) {
        int[] arr = {3,2,1};
        int[] numbers = new getLeastNumbers_offer_40().getLeastNumbers(arr, 2);
        System.out.println(Arrays.toString(numbers));
    }

    public int[] getLeastNumbers01(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr,k);
    }

    public int[] getLeastNumbers02(int[] arr, int k) {
        int len = arr.length;
        //题意中已经明确数组的长度只会大于等于k，所以在判断k如果等于len的情况下
        //直接返回结果，避免下面再创建优先队列带来的内存消耗
        if (len == k) {
            return arr;
        }
        int index = 0;
        int[] res = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) queue.add(i);
        //拿出优先队列前k个数放入结果集中
        while (index < k) {
            Integer poll = queue.poll();
            res[index++] = poll;
        }
        return res;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是前k-1个数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int low, int high, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, low, high);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 如果当前返回的j大于k，表示应该往前切
        if (j > k) {
            return quickSearch(nums, low, j - 1, k);
        }
        //否则，向后切
        return quickSearch(nums, j + 1, high, k);
    }

    // 小于j位置元素的在j的左边，大于j的在j的右边
    private int partition(int[] nums, int low, int high) {
        //记录作为基准点的值
        int tmp = nums[low];
        int i = low, j = high + 1;
        while (true) {
            while (++i <= high && nums[i] < tmp);
            while (--j >= low && nums[j] > tmp);
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        //挪动基准点到它应该的位置上
        nums[low] = nums[j];
        nums[j] = tmp;
        //返回此时基准点的下标
        return j;
    }
}
