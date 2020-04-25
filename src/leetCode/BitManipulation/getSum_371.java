package leetCode.BitManipulation;

/**
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * 两数相加分为两种情况：
 *  1.产生进位：先将两数进行与运算，然后将结果左移一位
 *  2.不产生进位：使用异或运算得到结果
 */
public class getSum_371 {
    public static void main(String[] args) {
        int i = getSum(-5, 2);
        System.out.println(i);
    }

    /**
     * 上面我们已经分析出来基本上就是两种情况：
     * 那么我们如何判断这两个数相加产生进位了呢？
     * 答：
     * 1.如果两个数相与得到的是0，那么就证明没有进位产生，我们直接返回 a ^ b即可
     * 2.如果与的结果不为0，那么我们将与的结果赋值给b，a更新为两个数的异或结果，然后重复上面两个步骤
     *  直到进位为0，返回结果就可以了
     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        int lower;
        int carrier;
        while (true) {
            lower = a ^ b;
            carrier = a & b;
            if (carrier == 0) break;
            a = lower;
            b = carrier << 1;
        }
        return lower;
    }
}
