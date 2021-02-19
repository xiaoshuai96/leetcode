package leetCode.slidingWindow;
/**
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *
 * 示例 1：
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * 示例 2：
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 * 提示：
 *     1 <= A.length <= 20000
 *     0 <= K <= A.length
 *     A[i] 为 0 或 1
 */
public class longestOnes_1004 {
    public static void main(String[] args) {
        int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int i = new longestOnes_1004().longestOnes(A, 3);
        System.out.println(i);
    }

    /**
     * 滑动窗口
     * 执行用时：4 ms, 在所有 Java 提交中击败了46.69% 的用户
     * 内存消耗：39.9 MB, 在所有 Java 提交中击败了18.25% 的用户
     * @param A
     * @param K
     * @return
     */
    public int longestOnes(int[] A, int K) {
        int res = 0;
        int len = A.length;
        int sum = 0;
        int left = 0,right = 0;
        while (right < len) {
            sum += (A[right] == 1 ? 0 : 1);
            while (sum > K) {
                sum -= (A[left] == 1 ? 0 : 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    /**
     * bilibili面试题
     * @param A
     * @param K
     * @return
     */
    public int longestOnes02(int[] A, int K) {
        int l = 0, r = 0, res = 0;
        while (r < A.length) {
            if (A[r] == 0) {
                if (K == 0) {
                    while (A[l] == 1) l++;
                    l++;
                } else {
                    K--;
                }
            }
            res = Math.max(res, ++r - l);
        }
        return res;
    }
}
