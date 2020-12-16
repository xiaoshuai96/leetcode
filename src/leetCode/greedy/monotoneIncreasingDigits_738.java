package leetCode.greedy;

/**
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 * 输入: N = 10
 * 输出: 9
 *
 * 示例 2:
 * 输入: N = 1234
 * 输出: 1234
 *
 * 示例 3:
 * 输入: N = 332
 * 输出: 299
 *
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 */
public class monotoneIncreasingDigits_738 {
    public static void main(String[] args) {
        int i = new monotoneIncreasingDigits_738().monotoneIncreasingDigits02(963856657);
        System.out.println(i);
    }

    /**
     * 算法思路：暴力解法，n如果小于10，直接返回即可符合条件；
     *          n大于9 ，从n开始一次判断每个数字是否符合条件，符合的直接返回
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        if (N < 10) return N;
        for (int i = N; i >= 0; --i) {
            if (isIncrease(i)) return i;
        }
        return -1;
    }
    private boolean isIncrease(int n){
        String s = String.valueOf(n);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - '0' >= s.charAt(i - 1) - '0') continue;
            return false;
        }
        return true;
    }

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了11.20% 的用户
     * 内存消耗：35.5 MB, 在所有 Java 提交中击败了46.79% 的用户
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits02(int N) {
        char[] arr = (N + "").toCharArray();
        int max = -1, idx = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (max < arr[i]) {
                max = arr[i];
                idx = i;
            }
            if (arr[i] > arr[i + 1]) {
                arr[idx] -= 1;
                for(int j = idx + 1;j < arr.length;j++) {
                    arr[j] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(new String(arr));
    }
}
