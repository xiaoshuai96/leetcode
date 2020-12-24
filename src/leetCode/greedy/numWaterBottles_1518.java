package leetCode.greedy;
/**
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 * 请你计算 最多 能喝到多少瓶酒。
 *
 * 示例 1：
 * 输入：numBottles = 9, numExchange = 3
 * 输出：13
 * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
 *
 * 示例 2：
 * 输入：numBottles = 15, numExchange = 4
 * 输出：19
 * 解释：你可以用 4 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 15 + 3 + 1 = 19 瓶酒。
 *
 * 示例 3：
 * 输入：numBottles = 5, numExchange = 5
 * 输出：6
 *
 * 示例 4：
 * 输入：numBottles = 2, numExchange = 3
 * 输出：2
 *
 * 提示：
 *     1 <= numBottles <= 100
 *     2 <= numExchange <= 100
 */
public class numWaterBottles_1518 {
    public static void main(String[] args) {
        int numBottles = 15,numExchange = 4;
        int i = new numWaterBottles_1518().numWaterBottles(numBottles, numExchange);
        System.out.println(i);
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：35.2 MB, 在所有 Java 提交中击败了62.24% 的用户
     * greedy
     * 算法思路：每一步都将酒喝完，将剩余的酒瓶去看能兑换多少瓶酒
     * @param numBottles
     * @param numExchange
     * @return
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange ) return numBottles;
        if (numBottles == numExchange) return numBottles + 1;
        int count = numBottles;
        while (numBottles >= numExchange) {
            //空酒瓶可以换的酒的瓶数
            int wine = numBottles / numExchange;
            count += wine;//喝过的酒的瓶数
            //空瓶个数
            int kong = numBottles % numExchange + wine;
            numBottles = kong;
        }
        return count;
    }
}
