package leetCode.array;

/**
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 *     A.length >= 3
 *     在 0 < i < A.length - 1 条件下，存在 i 使得：
 *         A[0] < A[1] < ... A[i-1] < A[i]
 *         A[i] > A[i+1] > ... > A[A.length - 1]
 *示例 1：
 *
 * 输入：[2,1]
 * 输出：false
 *
 * 示例 2：
 *
 * 输入：[3,5,5]
 * 输出：false
 *
 * 示例 3：
 *
 * 输入：[0,3,2,1]
 * 输出：true
 *
 *
 *
 * 提示：
 *
 *     0 <= A.length <= 10000
 *     0 <= A[i] <= 10000
 */
public class validMountainArray_941 {
    public static void main(String[] args) {
        boolean b = validMountainArray02(new int[]{9,8,7,6,5,4,3,2,1,0});
        System.out.println(b);
    }

    /**
     * 思路：找到“山顶”，然后看山脉是否符合要求
     * 执行用时：3 ms, 在所有 Java 提交中击败了11.40% 的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了52.71% 的用户
     * @param A
     * @return
     */
    public static boolean validMountainArray(int[] A){
        if (A.length < 3) return false;
        int maxIndex = 0;
        for (int i = 1;i < A.length;i++) {
            maxIndex = A[i] == Math.max(A[i],A[maxIndex]) ? i : maxIndex;
        }
        if (maxIndex == 0 || maxIndex == A.length - 1) return false;
        for (int i = maxIndex;i < A.length - 1;i++){
            if (A[i] > A[i+1]) continue;
            return false;
        }
        for (int j = maxIndex;j > 0;j--){
            if (A[j] > A[j - 1]) {
                continue;
            }
            return false;
        }
        return true;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了42.69% 的用户
     * @param A
     * @return
     */
    public static boolean validMountainArray02(int[] A){
        if (A.length < 3) return false;
        int low = 0,high = A.length - 1;
        while (low < A.length - 2 && A[low] < A[low+1]) {
            low++;
        }
        while (high > 1 && A[high] < A[high-1]) {
            high--;
        }
        return low == high;
    }
}
