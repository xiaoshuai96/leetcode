package leetCode.BitManipulation;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 2^31.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class hammingDistance_461 {
    public static void main(String[] args) {
        int i = hammingDistance02(1, 4 );
        System.out.println(i);
    }

    /** version 1.0
     * 执行用时 :1 ms, 在所有 Java 提交中击败了96.41% 的用户
     * 内存消耗 :38.8 MB, 在所有 Java 提交中击败了5.19%的用户
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance01(int x,int y){
        int count = 0;
        int res = x ^ y;
        String str = Integer.toBinaryString(res);
        int str_length = str.length()-1;
        while (str_length >= 0) {
            if (str.charAt(str_length) == '1') {
                count++;
            }
            str_length--;
        }
        return count;
    }

    /**
     * version 1.1
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :38.7 MB, 在所有 Java 提交中击败了5.19%的用户
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance02(int x,int y){
        int count = 0;
        int res = x ^ y;
        while (res != 0) {
            if (res % 2 == 1) count++;
            res /= 2;
        }
        return count;
    }
}
