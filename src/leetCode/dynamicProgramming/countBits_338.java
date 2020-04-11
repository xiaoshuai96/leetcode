package leetCode.dynamicProgramming;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
 * 计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 *
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * 进阶:
 *
 *     给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 *     要求算法的空间复杂度为O(n)。
 *     你能进一步完善解法吗？
 *     要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 */
public class countBits_338 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了80.91% 的用户
     * 内存消耗 :43.5 MB, 在所有 Java 提交中击败了5.32%的用户
     *
     * 通过最低有效位来获得状态转移函数。
     *
     * 观察 x 和 x′= x/2的关系：
     *
     * x  = (1001011101)二进制 = (605)十进制
     *
     * x′= (100101110)二进制 = (302)十进制
     *
     * 可以发现x′与x只有一位不同，这是因为x′可以看做x移除最低有效位的结果。
     *
     * 这样，我们就有了下面的状态转移函数：
     *
     * P(x)=P(x / 2)+(x mod  2)
     *
     *
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            // x / 2 is x >> 1 and x % 2 is x & 1
            ans[i] = ans[i >> 1] + (i & 1);
        return ans;

    }
}
