package leetCode.BitManipulation;
/**
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 *
 * 示例1:
 *  输入：num = 2（或者0b10）
 *  输出 1 (或者 0b01)
 *
 * 示例2:
 *  输入：num = 3
 *  输出：3
 *
 * 提示:
 *     num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 */
public class exchangeBits_interview_0507 {
    public static void main(String[] args) {

    }
    public int exchangeBits(int num) {
        //把num的偶数位值提取出来
        int even = num & 0x55555555;
        //把num的奇数位值提取出来
        int odd = num & 0xaaaaaaaa;
        //偶数位值左移一位，奇数位值右移一位，等效奇数位和偶数位交换
        even = even << 1;
        odd = odd >> 1;
        //把交换位置后的奇偶位合并
        return even + odd;
    }
}
