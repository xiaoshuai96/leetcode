package leetCode.array;

import java.util.*;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 */
public class containsDuplicate_217 {
    public static void main(String[] args) {
        int[] arr = {11,11,22,33};
        System.out.println(containsDuplicate(arr));
    }

    //耗时1743ms
    public static boolean containsDuplicate(int[] arr) {
        List<Integer> list = new ArrayList<>(arr.length);
        for (int i : arr) {
            if (list.contains(i)) return true;
            list.add(i);
        }
        return false;
    }

    //耗时1045ms
    public static boolean containsDuplicate02(int[] arr) {
        if (arr.length == 1 || arr.length ==0) return false;
        for (int i = 0;i < arr.length;i++) {
            for (int j = i+1; j < arr.length; j++) {
                if ((arr[i] ^ arr[j])==0 && (i != 0 || j != 0)) return true;
                if ((arr[i] ^ arr[j])==0 && (i == 0 && j == 0)) return true;
            }
        }
        return false;
    }

    //耗时336ms
    public static boolean containsDuplicate03(int[] nums) {
        if(nums.length == 1 || nums.length == 0) return false;
        for (int i = 0;i < nums.length;i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    //耗时5ms
    public static boolean containsDuplicate04(int[] arr){
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; ++i) {
            if (arr[i] == arr[i + 1]) return true;
        }
        return false;
    }

    //耗时14ms
    /**
     * 对于哈希表（Java 中的 HashSet 或 HashMap），search 和 insert 的平均时间复杂度为 O(1)O(1)O(1)。
     * 因此，通过使用哈希表，我们可以达到在线性时间复杂度解决问题。
     * @param arr
     * @return
     */
    public static boolean containDuplicate05(int[] arr){
        Set<Integer> set = new HashSet<>(arr.length);
        for (int i : arr) {
            if (set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }
}
