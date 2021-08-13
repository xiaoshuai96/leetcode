package leetCode.BitManipulation;

import java.util.Arrays;

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2^x ，则认为 n 是 2 的幂次方。
 *
 * 示例 1：
 * 输入：n = 1
 * 输出：true
 * 解释：2^0 = 1
 *
 * 示例 2：
 * 输入：n = 16
 * 输出：true
 * 解释：2^4 = 16
 *
 * 示例 3：
 * 输入：n = 3
 * 输出：false
 *
 * 示例 4：
 * 输入：n = 4
 * 输出：true
 *
 * 示例 5：
 * 输入：n = 5
 * 输出：false
 *
 * 提示：
 *     -2^31 <= n <= 2^31 - 1
 *
 * 进阶：你能够不使用循环/递归解决此问题吗？
 */
public class isPowerOfTwo_231 {
    public static void main(String[] args) {
        System.out.println(2 >> 1);
        boolean powerOfTwo = new isPowerOfTwo_231().isPowerOfTwo(16);
        System.out.println(powerOfTwo);
    }

    /**
     * n & n-1可以把n最低位的1变0，而当n & n-1 == 0时，则说明n只有一个1。
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;

    }

    /**
     * 老流氓解法：调用API
     * @param n
     * @return
     */
    public boolean isPowerOfTwo02(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}