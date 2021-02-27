package leetCode.array;

/**
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。
 * 自行车手从海拔为 0 的点 0 开始骑行。
 * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。
 * 请你返回 最高点的海拔 。
 *
 *
 * 示例 1：
 * 输入：gain = [-5,1,5,0,-7]
 * 输出：1
 * 解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
 *
 * 示例 2：
 * 输入：gain = [-4,-3,-2,-1,4,3,2]
 * 输出：0
 * 解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
 *
 * 提示：
 *     n == gain.length
 *     1 <= n <= 100
 *     -100 <= gain[i] <= 100
 */
public class largestAltitude_1732 {
    public static void main(String[] args) {
        new largestAltitude_1732().largestAltitude(new int[]{-4,-3,-2,-1,4,3,2});
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36 MB, 在所有 Java 提交中击败了84.00% 的用户
     *
     * 递推即可
     * @param gain
     * @return
     */
    public int largestAltitude(int[] gain) {
        int max = Integer.MIN_VALUE;
        int len = gain.length;
        int[] ans = new int[len + 1];
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] + gain[i - 1];
            max = Math.max(max, ans[i]);
        }
        return max < 1 ? 0 : max;
    }
}
