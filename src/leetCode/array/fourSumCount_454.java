package leetCode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，
 * 使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
 * 所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class fourSumCount_454 {
    public static void main(String[] args) {
        int[] A = {1,  2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = {0,  2};
        int i = fourSumCount(A, B, C, D);
        System.out.println(i);
    }

    /**
     * 以下内容摘自leetcode官方：
     * <p>
     * 我们可以将四个数组分成两部分，AAA 和 BBB 为一组，CCC 和 DDD 为另外一组。
     * <p>
     * 对于 AAA 和 BBB，我们使用二重循环对它们进行遍历，得到所有 A[i]+B[j]A[i]+B[j]A[i]+B[j] 的值并存入哈希映射中。
     * 对于哈希映射中的每个键值对，每个键表示一种 A[i]+B[j]A[i]+B[j]A[i]+B[j]，
     * 对应的值为 A[i]+B[j]A[i]+B[j]A[i]+B[j] 出现的次数。
     * <p>
     * 对于 CCC 和 DDD，我们同样使用二重循环对它们进行遍历。当遍历到 C[k]+D[l]C[k]+D[l]C[k]+D[l] 时，
     * 如果 −(C[k]+D[l])-(C[k]+D[l])−(C[k]+D[l]) 出现在哈希映射中，
     * 那么将 −(C[k]+D[l])-(C[k]+D[l])−(C[k]+D[l]) 对应的值累加进答案中。
     * <p>
     * 最终即可得到满足 A[i]+B[j]+C[k]+D[l]=0A[i]+B[j]+C[k]+D[l]=0A[i]+B[j]+C[k]+D[l]=0 的四元组数目。
     *
     * 执行用时：70 ms, 在所有 Java 提交中击败了87.36% 的用户
     * 内存消耗：56.6 MB, 在所有 Java 提交中击败了91.11% 的用户
     *
     * 时间复杂度：O(n^2)
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        int count = 0;
        for (int c : C) {
            for (int d : D) {
                if (map.containsKey(-c - d)) {
                    count += map.get(-c - d);
                }
            }
        }

        return count;
    }
}
