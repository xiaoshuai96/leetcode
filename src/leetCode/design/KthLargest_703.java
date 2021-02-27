package leetCode.design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 请实现 KthLargest 类：
 *     KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 *     int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 * 示例：
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *
 *
 * 提示：
 *     1 <= k <= 10^4
 *     0 <= nums.length <= 10^4
 *     -10^4 <= nums[i] <= 10^4
 *     -10^4 <= val <= 10^4
 *     最多调用 add 方法 10^4 次
 *     题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 */
public class KthLargest_703 {
    public static void main(String[] args) {
        KthLargest largest = new KthLargest(1, new int[]{-2});
        int a = largest.add(-3);
        int b = largest.add(0);
        int c = largest.add(2);
        int d = largest.add(-1);
        int e = largest.add(4);
        System.out.println(a+"-"+b+"-"+c+"-"+d+"-"+e);

    }

    /**
     * 超出时间限制
     */
    /*static class KthLargest {
        int kk;
        List<Integer> list;
        public KthLargest(int k, int[] nums) {
            list = new LinkedList<>();
            this.kk = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            int flag = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) >= val) {
                    flag = i;
                    break;
                }
            }
            if (flag == -1) {
                list.add(list.size(), val);
            } else {
                list.add(flag, val);
            }
            return list.get(list.size() - kk);
        }
    }*/

    static class KthLargest {
        PriorityQueue<Integer> pq;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for (int x : nums) {
                add(x);
            }
        }
        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
            return pq.peek();
        }
    }
}
