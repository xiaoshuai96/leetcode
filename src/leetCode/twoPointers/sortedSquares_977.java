package leetCode.twoPointers;

import java.util.Arrays;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 *
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 *
 * 提示：
 *
 *     1 <= A.length <= 10000
 *     -10000 <= A[i] <= 10000
 *     A 已按非递减顺序排序。
 */
public class sortedSquares_977 {
    public static void main(String[] args) {
        int[] A = new int[]{-4,-1,0,3,10};
        int[] square = sortedSquare(A);
        System.out.println(Arrays.toString(square));
    }

    /**
     * 朴实解法
     * 执行用时：2 ms, 在所有 Java 提交中击败了66.81% 的用户
     * 内存消耗：39.9 MB, 在所有 Java 提交中击败了99.67% 的用户
     * @param A
     * @return
     */
    public static int[] sortedSquare(int[] A){
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = A[i] * A[i];
        }
        Arrays.sort(res);
        return res;
    }


    /**
     * towPointers
     *
     * 执行用时：2 ms, 在所有 Java 提交中击败了66.81% 的用户
     * 内存消耗：40.5 MB, 在所有 Java 提交中击败了62.81% 的用户
     * @param A
     * @return
     */
    public static int[] sortedSquare02(int[] A){
        int len = A.length;
        if (A.length == 0) return A;
        if (A.length == 1) {
            A[0] *= A[0];
            return A;
        }
        int tag = -1;//记录递增子数组的第一个元素下标
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                tag = i;
                break;
            }
        }

        int[] res = new int[len];
        //i：递减子数组的最后一个数的下标 j:递增子数组的第一个数的下标
        int i = tag - 1,j = tag,index = 0;
        while (i >= 0 || j < len) {
            //如果递减子数组已经遍历结束了，那么就只把递增子数组中剩余的数字依次添加到res中即可
            if (i < 0) {
                res[index] = A[j] * A[j];
                ++j;
            } else if (j == len) {//同上情况正好相反
                res[index] = A[i] * A[i];
                --i;
            /**
             * 如果当前i指向的数字的平方大小于j指向的数的平方
             * 就将i指向的数字的平方存入res中，并且i向左移动
             */
            } else if (A[i] * A[i] < A[j] * A[j]) {
                res[index] = A[i] * A[i];
                --i;
            } else {//剩余的最后一种情况指的是上一种情况的剩余情况
                res[index] = A[j] * A[j];
                ++j;
            }
            //每次添加完之后，res数组下标后移
            ++index;
        }
        return res;
    }

    /**
     * twoPointers
     * 官方题解
     * 仔细揣摩之下，细思极恐（狗头），02解法的思路是从两个子数组的最小值比较，还要考虑边界的问题
     * 而这种解法完全不用care：从两个子数组的最大值（每次比较都是两个数的平方比较，保证正数）开始比较
     * 倒着将每次比较的最大值放入结果中，最终在两个指针相遇之后停止，返回结果
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：40.7 MB, 在所有 Java 提交中击败了23.21% 的用户
     */
    public static int[] sortedSquare03(int[] A){
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[pos] = A[i] * A[i];
                ++i;
            } else {
                ans[pos] = A[j] * A[j];
                --j;
            }
            --pos;
        }
        return ans;
    }


}
