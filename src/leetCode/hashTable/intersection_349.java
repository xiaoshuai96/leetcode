package leetCode.hashTable;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 *
 * 说明:
 *
 *     输出结果中的每个元素一定是唯一的。
 *     我们可以不考虑输出结果的顺序。
 */
public class intersection_349 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] arr = intersection01(nums1, nums2);
        System.out.println(Arrays.toString(arr));
    }
    //version 1.0 想的有点复杂了，主要是不了解set集合中的retainAll方法
    public static int[] intersection01(int[] nums1, int[] nums2){
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int n1 : nums1){
            if (list.contains(n1)) continue;
            list.add(n1);
        }
        for (int n2 : nums2) {
            if (list.contains(n2)) {
                set.add(n2);
            }
        }
        Object[] objects = set.toArray();
        int[] arr = new int[objects.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)objects[i];
        }
        return arr;

    }
    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了95.82% 的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了80.62% 的用户
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection02(int[] nums1,int[] nums2){
        //先过滤掉两个数组中重复的数字
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        //将set1和set2的交集的结果保存在set1中
        set1.retainAll(set2);

        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }
}
