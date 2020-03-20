package leetCode.math;

/**
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 *
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 *
 *     选出任一 x，满足 0 < x < N 且 N % x == 0 。
 *     用 N - x 替换黑板上的数字 N 。
 *
 * 如果玩家无法执行这些操作，就会输掉游戏。
 *
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 *
 * 示例 2：
 *
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 *
 *
 *
 * 提示：
 *
 *     1 <= N <= 1000
 *
 * 数学思路：只要是在自己的回合碰到2就赢
 */
public class divisorGame_1025 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :36 MB, 在所有 Java 提交中击败了5.04%的用户
     * @param N
     * @return
     */
    public static boolean divisorGame01(int N){
        return N % 2 == 0;
    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :36.4 MB, 在所有 Java 提交中击败了5.04%的用户
     * @param N
     * @return
     */
    public static boolean divisorGame02(int N){
        return (N&1)==1?false:true;
    }
}
