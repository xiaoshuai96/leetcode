package leetCode.design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2  缓存容量  )
 *         cache.put(1,1);
 *         cache.put(2,2);
 *         cache.get(1);       // 返回  1
 *         cache.put(3,3);    // 该操作会使得密钥 2 作废
 *         cache.get(2);       // 返回 -1 (未找到)
 *         cache.put(4,4);    // 该操作会使得密钥 1 作废
 *         cache.get(1);       // 返回 -1 (未找到)
 *         cache.get(3);       // 返回  3
 *         cache.get(4);       // 返回  4
 */

/**
 * 执行用时：35 ms, 在所有 Java 提交中击败了54.72% 的用户
 * 内存消耗：47 MB, 在所有 Java 提交中击败了26.73% 的用户
 */
public class LRUCache_interview_16_25 {
    int capacity;
    Map<Integer, Integer> map;

    //初始化
    public LRUCache_interview_16_25(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 先删除旧的位置，再放入新位置
        Integer value = map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            //如果只是put，那么会替换该key的value，我们需要的是在插入之后变换该KV对所处的位置
            map.put(key, value);
            return;
        }
        map.put(key, value);
        // 超出capacity，删除最久没用的,利用迭代器删除第一个
        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}
