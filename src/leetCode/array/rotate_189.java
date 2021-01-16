package leetCode.array;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明:
 *
 *     尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 *     要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class rotate_189 {
    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        new rotate_189().rotate03(nums,2);
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了35.57% 的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了77.84% 的用户
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if(k < 1) return ;
        k %= nums.length;
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        for (; i < nums.length - k; i++) {
            stack.addLast(nums[i]);
        }
        for (int j = nums.length - 1; j >= 0 && k > 0; j--,k--) {
            stack.addFirst(nums[j]);
        }
        i = 0;
        while (!stack.isEmpty()) {
            Integer first = stack.pollFirst();
            nums[i++] = first;
        }
    }

    /**
     * 超出时间限制
     * @param nums
     * @param k
     */
    public void rotate02(int[] nums, int k){
        int len = nums.length;
        if(k < 1) return ;
        k %= len;
        int temp;
        for (int i = 0; i < k; i++) {
            temp = nums[len - 1];
            for (int j = 0; j < len; j++) {
                int ans = nums[j];
                nums[j] =  temp;
                temp    =  ans;
            }
        }
    }

    /**
     * 算法思路：翻转数组
     * 1.将整个数组进行翻转；
     * 2.将数组前k个元素进行翻转；
     * 3.将数组第k个元素之后的子数组进行翻转
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了21.16% 的用户
     * @param nums
     * @param k
     */
    public void rotate03(int[] nums, int k){
        int len = nums.length;
        k %= len;
        reverse(nums,0,len - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,len - 1);
    }
    private void reverse(int[] nums,int start,int end){
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
