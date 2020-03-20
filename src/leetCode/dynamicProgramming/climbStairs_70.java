package leetCode.dynamicProgramming;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 *
 */
public class climbStairs_70 {
    public static void main(String[] args){
        int a = climbStairs(5);
        System.out.println(a);
        int b = climbStairs2(5);
        System.out.println(b);
    }

    /**
     * 方法一：动态规划
     *  看到这个题，刚开始我是没有将它和斐波那契数列联系在一块的，后来一看解析，忽然之间就想明白了。
     *  将抽象的问题与现实中的问题对应起来对解题和理解是非常有帮助的。
     *  从第四个数(下标为3)开始，当前数总是前两个数之和
     *  通过前后数之间的联系，很快就能解决该问题。
     * @param n
     * @return
     */
    public static int climbStairs(int n){
        if(n == 1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3;i <= n;i++) {
            dp[i] += dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    public static int climbStairs2(int n){
        if(n == 1) return 1;
        int first = 1;
        int second = 2;
        for (int i = 3;i <= n;i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
    /**
     * 斐波那契公式
     */
    public static int climbStairs3(int n){
        double Sqrt=Math.sqrt(5);
        double fibn=Math.pow((1+Sqrt)/2,n+1)-Math.pow((1-Sqrt)/2,n+1);
        return (int)(fibn/Sqrt);
    }
}
