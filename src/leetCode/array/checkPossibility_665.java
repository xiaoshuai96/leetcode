package leetCode.array;

/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，
 * 总满足 array[i] <= array[i + 1]。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 *
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 说明：
 *
 *     1 <= n <= 10 ^ 4
 *     - 10 ^ 5 <= nums[i] <= 10 ^ 5
 *
 */
public class checkPossibility_665 {
    public static void main(String[] args) {
        boolean b = checkPossibility(new int[]{3,4,2,3});
        System.out.println(b);
    }

    /**
     * 1  2  3  4  3  5  6  7
     *
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int cnt = 0;//记录操作过几次，如果大于1次直接返回false即可
        /**
         * 下面算法的含义：
         *      1.先比较当前位置和后一个位置的大小，如果curr <= next  ,直接跳过本次循环（符合非递减）
         *          如果curr > next ,判断next后面紧跟的一个数和curr的关系
         *              如果curr > next.next 就将next的值赋给curr
         *              如果curr <= next.next 就将curr的值赋给 next
         */
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i-1] <= nums[i]) {
                continue;
            }
            cnt++;
            if (i-2>=0 && nums[i-2] > nums[i]) {
                nums[i] = nums[i-1];
            }else {
                nums[i-1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}
