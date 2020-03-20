package leetCode.math;

/**
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 *
 * 示例 1：
 *
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 *
 * 示例 2：
 *
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 *
 *
 *
 * 提示：
 *
 *     1 <= n <= 10^5
 *
 */
public class subtractProductAndSum_1281 {
    public static void main(String[] args) {
        int i = subtractProductAndSum02(4421);
        System.out.println(i);
    }

    /**
     * 转成字符数组再操作
     * 执行用时 :9 ms, 在所有 Java 提交中击败了5.10% 的用户
     * 内存消耗 :37.2 MB, 在所有 Java 提交中击败了5.02%的用户
     * @param n
     * @return
     */
    public static int subtractProductAndSum(int n){
        if((n+"").length() == 1) return n*n-n;
        String[] s = (n+"").split("");
        int sum = 0,acc = 1;
        for(int i = 0;i < s.length;i++){
            sum += (Integer.parseInt(s[i]));
            acc *= (Integer.parseInt(s[i]));
        }
        return acc - sum;
    }

    /**
     * 直接在原数上操作
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :36.3 MB, 在所有 Java 提交中击败了5.02%的用户
     * @param n
     * @return
     */
    public static int subtractProductAndSum02(int n) {
        int sum = 0,acc = 1;
        while (n != 0) {
            int temp = n % 10;
            sum += temp;
            acc *= temp;
            n /= 10;
        }
        return acc - sum;
    }
}
