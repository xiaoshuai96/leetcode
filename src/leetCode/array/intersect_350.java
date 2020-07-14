package leetCode.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 说明：
 *     输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 *     我们可以不考虑输出结果的顺序。
 *
 * 进阶：
 *     如果给定的数组已经排好序呢？你将如何优化你的算法？
 *     如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 *     如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，
 *     并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class intersect_350 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] ints = intersect01(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 先确定长度比较短的数组nums1，使用map集合将数(key)、数的个数(value)都存储起来，然后再遍历数组nums2，如果nums2中当前数字在
     * map集合中有对应的key且value不为0的时候，就将当前这个数字存到新建的数组temp中，然后该key对应的value值减1
     * 紧接着判断count的值是不是为0了，如果是，就将该key移除掉，如果不是将该key和更新的value存入map中（旧的key会被覆盖掉）
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect01(int[] nums1,int[] nums2){
        if (nums1.length > nums2.length) {
            return intersect01(nums2,nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : nums1){
            map.put(a,map.getOrDefault(a,0) + 1);
        }
        int[] temp = new int[nums1.length];
        int index = 0;
        for(int b : nums2){
            int count = map.getOrDefault(b,0);
            if (count > 0) {
                temp[index++] = b;
                count--;
                if (count > 0) {
                    map.put(b, count);
                } else {
                    map.remove(b);
                }
            }
        }
        return Arrays.copyOfRange(temp,0,index);

    }
}
