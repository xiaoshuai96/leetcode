package leetCode.array;
/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 *
 * 示例 1：
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 *
 * 示例 2：
 * 输入：
 * nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 *
 * 说明：
 *     nums 的长度范围为 [0, 10000]。
 *     任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 */
public class pivotIndex_724 {
    public static void main(String[] args) {

    }

    /**
     * 算法思路：
     * 执行用时：2 ms, 在所有 Java 提交中击败了55.66% 的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了44.38% 的用户
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        if(len < 1) return -1;
        int[] pre = new int[len];
        int[] bac = new int[len];
        //正序求和
        pre[0] = nums[0];
        for(int i = 1;i < len;i++){
            pre[i] = pre[i - 1] + nums[i];
        }
        bac[len - 1] = nums[len - 1];
        for(int i = len - 2;i >= 0;--i){
            bac[i] = bac[i + 1] + nums[i];
        }
        for(int i = 0;i < len;i++){
            if(pre[i] == bac[i]) return i;
        }
        return -1;
    }
}
