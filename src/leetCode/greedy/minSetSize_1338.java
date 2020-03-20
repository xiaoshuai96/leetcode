package leetCode.greedy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 * 返回至少能删除数组中的一半整数的整数集合的最小大小。
 *
 * 示例 1：
 * 输入：arr = [3,3,3,3,5,5,5,2,2,7]
 * 输出：2
 * 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
 * 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
 * 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
 *
 * 示例 2：
 * 输入：arr = [7,7,7,7,7,7]
 * 输出：1
 * 解释：我们只能选择集合 {7}，结果数组为空。
 *
 * 示例 3：
 * 输入：arr = [1,9]
 * 输出：1
 *
 * 示例 4：
 * 输入：arr = [1000,1000,3,7]
 * 输出：1
 *
 * 示例 5：
 * 输入：arr = [1,2,3,4,5,6,7,8,9,10]
 * 输出：5
 *
 * 提示：
 *     1 <= arr.length <= 10^5
 *     arr.length 为偶数
 *     1 <= arr[i] <= 10^5
 *
 */
public class minSetSize_1338 {
    public static void main(String[] args) {
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        int i = minSetSize(arr);
        System.out.println(i);
    }
    //greedy算法
    public static int minSetSize(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //创建各个值的数组长度
        int[] lens = new int[map.size()];
        int index = 0;
        for (int val : map.values()) {
            lens[index] = val;
            index++;
        }
        Arrays.sort(lens);//[1,2,3,4]
        //优先选择最大的
        int arrLength = arr.length/2;
        int tmp = 0;
        for (int i = lens.length-1;i >= 0;i--) {
            tmp += lens[i];
            if (tmp >= arrLength) return lens.length - i;
        }
        return -1;

    }
}
