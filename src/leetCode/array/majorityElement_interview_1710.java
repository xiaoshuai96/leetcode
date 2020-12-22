package leetCode.array;
/**
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *
 * 示例 1：
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *
 * 示例 2：
 * 输入：[3,2]
 * 输出：-1
 *
 * 示例 3：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 说明：
 * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 */
public class majorityElement_interview_1710 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了70.33% 的用户
     * 内存消耗：41.3 MB, 在所有 Java 提交中击败了97.07% 的用户
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length < 1) return -1;
        int first = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (first == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                first = nums[i];
                count = 1;
            }
        }
        //校验
        count = 0;
        for(int i : nums){
            if (first == i) count++;
            if (count > nums.length / 2) return first;
        }
        return -1;
    }
}
