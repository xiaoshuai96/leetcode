package leetCode.math;

import javax.jnlp.IntegrationService;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 限制：
 *     1 <= target <= 10^5
 *
 */
public class findContinuousSequence_interview_57 {
    public static void main(String[] args) {
        findContinuousSequence01(0);

    }

    /**
     * 执行用时 :4 ms, 在所有 Java 提交中击败了75.52% 的用户
     * 内存消耗 :37.6 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence01(int target) {
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 1; i <= target/2; i++) {
            int sum = 0,j = i;
            //找到符合条件的开始和结束下标
            while (sum < target) {
                sum += j;
                j++;
            }
            if (sum == target) {
                int[] arr = new int[j-i];
                for (int k = 0; k < j - i; k++) {
                    arr[k] = k+i;
                }
                res.add(arr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
