package leetCode.math;

/**
 * 存在一个长度为 n 的数组 arr ，其中 arr[i] = (2 * i) + 1 （ 0 <= i < n ）。
 * 一次操作中，你可以选出两个下标，记作 x 和 y （ 0 <= x, y < n ）并使 arr[x]
 * 减去 1 、arr[y] 加上 1 （即 arr[x] -=1 且 arr[y] += 1 ）。
 * 最终的目标是使数组中的所有元素都 相等 。题目测试用例将会
 * 保证 ：在执行若干步操作后，数组中的所有元素最终可以全部相等。
 * 给你一个整数 n，即数组的长度。请你返回使数组 arr 中所有元素相等所需的 最小操作数
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：2
 * 解释：arr = [1, 3, 5]
 * 第一次操作选出 x = 2 和 y = 0，使数组变为 [2, 3, 4]
 * 第二次操作继续选出 x = 2 和 y = 0，数组将会变成 [3, 3, 3]
 *
 * 示例 2：
 * 输入：n = 6
 * 输出：9
 *
 * 提示：
 *     1 <= n <= 10^4
 *
 */
public class minOperations_1551 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：35.4 MB, 在所有 Java 提交中击败了72.52% 的用户
     * @param n
     * @return
     */
    public int minOperations(int n) {
        return n * n / 4;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了57.02% 的用户
     * 内存消耗：35.5 MB, 在所有 Java 提交中击败了61.42% 的用户
     * @param n
     * @return
     */
    public int minOperations02(int n) {
        if(n <= 1) return 0;
        int count = 0,temp = 1;
        for(int i = 0;i <= n;i++){
            if(n > temp){
                count += (n - temp);
            } else break;
            temp += 2;
        }
        return count;
    }
}
