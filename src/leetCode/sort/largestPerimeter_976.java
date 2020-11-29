package leetCode.sort;

import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 * 示例 1：
 * 输入：[2,1,2]
 * 输出：5
 *
 * 示例 2：
 * 输入：[1,2,1]
 * 输出：0
 *
 * 示例 3：
 * 输入：[3,2,3,4]
 * 输出：10
 *
 * 示例 4：
 * 输入：[3,6,2,3]
 * 输出：8
 *
 * 提示：
 *
 *     3 <= A.length <= 10000
 *     1 <= A[i] <= 10^6
 */
public class largestPerimeter_976 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了97.44% 的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了70.02% 的用户
     *
     * 算法思路：首先明确符合构成三角形的条件：三条边，任意两条边之和大于第三条边
     * 首先对数组进行排序，既然是要求最大的周长，那么直接从排过序的数组的末尾开始
     * 判断，一旦遇见符合条件的三条边，即就是最大周长
     * @param A
     * @return
     */
    public static int largestPerimeter(int[] A){
        if(A.length < 3) return 0;
        Arrays.sort(A);
        for(int i = A.length - 1; i >= 2; i--) {
            int a = A[i];
            int b = A[i - 1];
            int c = A[i - 2];
            if(a < b + c){
                return a + b + c;
            }
        }
        return 0;
    }
}
