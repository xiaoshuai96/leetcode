package leetCode.BitManipulation;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 *
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 */
public class hammingWeight_offer_15 {
    public static void main(String[] args) {
    }

    /**
     * Integer.bitCount()源码
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.45% 的用户
     * 内存消耗：35.6 MB, 在所有 Java 提交中击败了76.73% 的用户
     * @param i
     * @return
     */
    public static int hammingWeight(int i){
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.45% 的用户
     * 内存消耗：35.6 MB, 在所有 Java 提交中击败了78.59% 的用户
     * 思路：每次目标数和1进行与运算，如果n表示二进制最后一位是1，则和1进行与运算的结果为1，否则为0
     * 然后目标n右移一位进行下次判断
     * @param n
     * @return
     */
    public static int hammingWeight02(int n){
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.45% 的用户
     * 内存消耗：35.4 MB, 在所有 Java 提交中击败了91.35% 的用户
     * 下面解题思路和02解法思路是相通的
     * 每次让目标数和一个比目标数小1的数进行与运算（相同的1得出1），就可以依次确认每一位的1或者0了
     * @param n
     * @return
     */
    public static int hammingWeight03(int n){
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
}
