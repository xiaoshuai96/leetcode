package leetCode.backTracking;
import java.util.LinkedList;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class numSquares_279 {
    public static void main(String[] args) {
        int i = new numSquares_279().numSquares(262);
        System.out.println(i);
    }
    //超出时间限制
    int res = Integer.MAX_VALUE;
    public int numSquares(int n) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (i * i <= n) {
                list.add(i * i);
            }
        }
        int[] nums = new int[list.size()];
        for(int i = 0; i < nums.length;i++) nums[i] = list.get(i);
        list.clear();
        backTrack(list,nums,n,0);
        return res;
    }
    private void backTrack(LinkedList<Integer> list, int[] nums, int target, int begin){
        if (target == 0) {
            res = Math.min(list.size(),res);
            return ;
        }
        for (int i = begin; i < nums.length; i++) {
            if (target - nums[i] < 0) {
                break;
            }
            list.addLast(nums[i]);
            backTrack(list, nums, target - nums[i], i);
            list.removeLast();
        }
    }

    protected boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }

    public int numSquares02(int n) {
        // four-square and three-square theorems.
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;

        if (this.isSquare(n))
            return 1;
        // enumeration to check if the number can be decomposed into sum of two squares.
        for (int i = 1; i * i <= n; ++i) {
            if (this.isSquare(n - i * i))
                return 2;
        }
        // bottom case of three-square theorem.
        return 3;
    }
}
