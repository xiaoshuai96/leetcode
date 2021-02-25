package leetCode.slidingWindow;
import java.util.*;

/**
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 * 返回 A 中好子数组的数目。
 *
 *
 * 示例 1：
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 *
 * 示例 2：
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *
 *
 * 提示：
 *     1 <= A.length <= 20000
 *     1 <= A[i] <= A.length
 *     1 <= K <= A.length
 */
public class subarraysWithKDistinct_992 {
    public static void main(String[] args) {
        int[] A = {1,2,1,2,3};
        int i = new subarraysWithKDistinct_992().subarraysWithKDistinct(A, 2);
    }
    public int subarraysWithKDistinct(int[] A, int K) {
        int count = 0;
        int len = A.length;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            list.add(A[i]);
            int tmp = K - 1;
            for (int j = i + 1; j < len; j++) {
                if (tmp != 0) {
                    if (!list.contains(A[j])) {
                        tmp--;
                    }
                    list.add(A[j]);
                } else {
                    for (Integer in : list) {
                        System.out.print(in+"\t");
                    }
                    System.out.println();
                    //等于0的情况
                    if (list.contains(A[j])) {
                        list.add(A[j]);
                    }
                    count++;
                }

            }
            list.clear();
        }
        return count;
    }
}
