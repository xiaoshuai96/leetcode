package leetCode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 *
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 *
 * 示例 2:
 *
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 *
 * 提示：
 *
 *     0 <= A.length <= 40000
 *     0 <= A[i] < 40000
 *
 */
public class minIncrementForUnique_945 {
    public static void main(String[] args) {
        int i = minIncrementForUnique02(new int[]{2,2,2,2,2,2,2,2,2,2,4});
        System.out.println(i);
    }

    /**
     * 力扣执行超出时间限制……
     * 从第二个数字开始，依次和前面的数字进行比较，如果有和前面数字相同的，则加一，直至前面的数字中
     * 没有和该数相同的数字为止
     *
     * @param A
     * @return
     */
    public static int minIncrementForUnique(int[] A) {
        if (A.length == 0 || A.length == 1) {
            return 0;
        }
        int count = 0;
        List<Integer> list = new ArrayList<>();
        list.add(A[0]);
        for (int i = 1; i < A.length; i++) {
            if (list.contains(A[i])) {
                while (list.contains(A[i])) {
                    A[i] += 1;
                    count++;
                }
            }
            list.add(A[i]);
        }
        return count;
    }

    /**
     * leetcode官方
     * @param A
     * @return
     */
    public static int minIncrementForUnique02(int[] A) {
        int[] count = new int[80000];
        for (int x: A) count[x]++;
        int ans = 0, taken = 0;
        for (int x = 0; x < 80000; ++x) {
            if (count[x] >= 2) {
                taken += count[x] - 1;
                ans -= x * (count[x] - 1);
            }
            else if (taken > 0 && count[x] == 0) {
                taken--;
                ans += x;
            }
        }
        return ans;
    }
}
