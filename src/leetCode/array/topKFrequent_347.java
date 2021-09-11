package leetCode.array;

import java.util.*;
import java.util.stream.Stream;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 提示：
 *     1 <= nums.length <= 10^5
 *     k 的取值范围是 [1, 数组中不相同的元素的个数]
 *     题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 */
public class topKFrequent_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        /**
         * 小于k的频率的直接舍弃掉
         * 1.如果当前堆的大小小于k，直接加入堆即可
         * 2.如果k >= 堆的大小了，那么看下堆顶的频次是否小于遍历到的元素的频次，如果是，将堆顶的元素用新加入的替换掉
         */
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        //取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
