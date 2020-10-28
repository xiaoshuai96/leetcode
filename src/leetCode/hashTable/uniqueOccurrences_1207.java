package leetCode.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 *
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 *
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *
 *
 *
 * 提示：
 *
 *     1 <= arr.length <= 1000
 *     -1000 <= arr[i] <= 1000
 */
public class uniqueOccurrences_1207 {
    public static void main(String[] args) {


    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了91.43% 的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了89.92% 的用户
     * @param arr
     * @return
     */
    public static boolean uniqueOccurrences(int[] arr){
        if(arr.length == 1) return true;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        ArrayList<Integer> tmp = new ArrayList<>();
        for(Integer key : map.keySet()){
            if (tmp.contains(map.get(key))) return false;
            tmp.add(map.get(key));
        }
        return true;
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了91.43% 的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了12.27% 的用户
     * @param arr
     * @return
     */
    public static boolean uniqueOccurrences02(int[] arr){
        if (arr.length == 1) return true;
        /**
         * 如果目标数组为：1,2,2,1,1,3
         * 1: 1001
         * 2: 1002
         * 3: 1003
         * 0: 1000
         * -1: 999
         * -1000: 0
         */
        int[] count = new int[2001];
        ArrayList<Object> list = new ArrayList<>();
        for (int i : arr) count[arr[i]+1000]++;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0 && list.contains(count[i])) {
                return false;
            } else if (count[i] == 0) {
                continue;
            } else {
                list.add(count[i]);
            }
        }
        return true;

    }
}
