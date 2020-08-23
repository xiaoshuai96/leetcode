package leetCode.BitManipulation;

/**
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1:
 *
 * 输入: [5,7]
 * 输出: 4
 *
 * 示例 2:
 *
 * 输入: [0,1]
 * 输出: 0
 */
public class rangeBitwiseAnd_201 {
    public static void main(String[] args) {
        int i = rangeBitwiseAnd(10,20);
        System.out.println(i);
    }

    /**
     * 暴力法超出时间限制，无法AC
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd(int m,int n){
        if (m == n) {
            return m;
        }
        if (n - m == 1) {
            return m & n;
        }
        int res = m;
        for (int i = m + 1; i <= n; i++) {
            res &= i;
        }
        return res;
    }

    /**
     * 位移
     * 执行用时：8 ms, 在所有 Java 提交中击败了15.48% 的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了69.92% 的用户
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd02(int m,int n){
        int shift = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

    /**
     * Brian Kernighan 算法：消除二进制串最右边的1
     * 执行用时：6 ms, 在所有 Java 提交中击败了99.82% 的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了80.69% 的用户
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd03(int m ,int n){
        while (m < n) {
            n = n & (n - 1);
        }
        return n;
    }

}
