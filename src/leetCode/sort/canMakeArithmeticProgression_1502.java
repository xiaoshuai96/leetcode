package leetCode.sort;

import java.util.Arrays;

/**
 * 给你一个数字数组 arr 。
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：arr = [3,5,1]
 * 输出：true
 * 解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，
 * 可以形成等差数列。
 *
 * 示例 2：
 *
 * 输入：arr = [1,2,4]
 * 输出：false
 * 解释：无法通过重新排序得到等差数列。
 *
 * 提示：
 *
 *     2 <= arr.length <= 1000
 *     -10^6 <= arr[i] <= 10^6
 */
public class canMakeArithmeticProgression_1502 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了100.00% 的用户
     * 先排序，再去判断每两个相邻的数之间的差值的绝对值是否相同
     * tips：一般情况下，出题人是不希望破坏原本的数组的，所以我们可以复制一份进行操作
     * @param arr
     * @return
     */
    public static boolean canMakeArithmeticProgression(int[] arr){
        Arrays.sort(arr);
        int x = arr[1] - arr[0];
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i+1] - arr[i] != x) {
                return false;
            }
        }
        return true;
    }
}
