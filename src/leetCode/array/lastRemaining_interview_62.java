package leetCode.array;

import java.util.ArrayList;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 *
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 * 限制：
 *     1 <= n <= 10^5
 *     1 <= m <= 10^6
 *
 */
public class lastRemaining_interview_62 {
    public static void main(String[] args) {
       int i = lastRemaining(8, 4);
       System.out.println(i);
    }

    /**
     * 执行用时 :1140 ms, 在所有 Java 提交中击败了12.71% 的用户
     * 内存消耗 :41.8 MB, 在所有 Java 提交中击败了100.00%的用户
     * 虽然是用arraylist存储元素，但是我们需要将它想成环形（头尾相连），寻找需要删除的元素时需要知道
     * 前一个被删除的元素的下标，既然是环形的数组，那么在删除完一个之后，后面的元素就会相继补上去，那么
     * 这个位置就要减一，如果超出该集合的size就需要使用mod来判断位置
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n,int m){
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        //0   1   2   3   4
        //2   0   4   1
        int index = 0;
        while (n > 1) {
            index = (index + m -1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    /**
     * 数学解法
     * 执行用时 :7 ms, 在所有 Java 提交中击败了99.88% 的用户
     * 内存消耗 :36.3 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining02(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
