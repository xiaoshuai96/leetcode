package leetCode.recursion;
/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * 示例 2：
 *
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * 示例 3：
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * 提示：
 *
 *     0 ≤ N ≤ 30
 *
 */
public class fib_509 {
    public static void main(String[] args) {
        int i = fib03(5);
        System.out.println(i);
    }

    //对数组操作的优化
    public static int fib03(int n){
        if (n == 1 || n == 2) {
            return 1;
        }
        int prev = 1,curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    //数组操作
    public static int fib01(int n){
        if (n <= 1) {
            return n;
        }
        return memory(n);
    }
    public static int memory(int n){
        int[] res = new int[n+1];
        res[1] = 1;
        for (int i = 2; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }


    //递归操作
    public static int fib02(int n){
        if (n <= 1) {
            return n;
        }
        return fib02(n-1)+fib02(n-2);
    }

}
