package leetCode.twoPointers;
/**
 * 给定一个含有n个正整数的数组和一个正整数s，找出该数组中满足其和≥s的长度最小的连续子数组，
 * 并返回其长度。如果不存在符合条件的连续子数组，返回0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组[4,3]是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n)时间复杂度的解法,请尝试O(nlogn)时间复杂度的解法。
 */
public class minSubArrayLen_209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int i = minSubArrayLen02(7, nums);
        System.out.println(i);
    }

    /**
     * 执行用时：213 ms, 在所有 Java 提交中击败了6.96%的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s,int[] nums){
        int left = 0,right = 0,res = 0;
        while (left < nums.length && right < nums.length) {
            if (add(left,right,nums) >= s) {
                res = res == 0 ? right - left + 1 : Math.min(res,right - left + 1);
                left++;
            } else {
                right++;
            }
        }
        return res;
    }
    private static int add(int begin,int end,int[] nums){
        int sum = 0;
        for(int i = begin;i <= end;i++){
            sum += nums[i];
        }
        return sum;
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了83.23%的用户
     * 内存消耗：39.8 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen02(int s,int[] nums){
        int i = 0;
        int sum = 0;
        int len = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                len = len == 0 ? j - i + 1 : Math.min(len, j - i + 1);
                sum -= nums[i++];//减去首位数字，向后滑动
            }
        }
        return len;
    }
}
