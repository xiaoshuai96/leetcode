package leetCode.array;
/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 *
 * 注意：
 *
 *     输入的数组只包含 0 和1。
 *     输入数组的长度是正整数，且不超过 10,000。
 */
public class findMaxConsecutiveOnes_485 {
    public static void main(String[] args) {

    }

    /**
     *
     * 算法思路：使用临时变量count进行局部统计，如果不符合设定条件，则去计算MaxCount和count中的较大值
     * 然后将count置为0；在循环结束的时候还需要再比较一次：例如nums为{1}
     * 执行用时：2 ms, 在所有 Java 提交中击败了90.66% 的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了28.80% 的用户
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int MaxCount = 0,count = 0;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            if(nums[i] == 1){
                count++;
            }else{
                MaxCount = Math.max(count,MaxCount);
                count = 0;
            }
        }
        return MaxCount = Math.max(count,MaxCount);
    }
}
