package leetCode.greedy;
/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ，
 * 所以你永远不可能到达最后一个位置。
 *
 *
 */
public class canJump_55 {
    public static void main(String[] args) {

    }
    public static boolean canJump01(int[] nums) {
        if (nums.length == 1) return true;
        // 直接寻找
        int i, m;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) { // 只有0的时候会出现无法向后继续寻找
                for (m = 0; m < i; m++) {
                    if (nums[m] + m > i) break;  // 说明能往后移动
                }
                if (m == i) return false;
            }
        }
        return true;
    }

    /**
     * 解题思路：
     * 1.如果某一个作为起跳点的格子可以跳跃的距离是3，那么表示后面3个格子都可以作为起跳点。
     * 2.可以对每一个能作为起跳点的格子都尝试跳一次，把能跳到最远的距离不断更新。
     * 3.如果可以一直跳到最后，就成功了。
     * @param nums
     * @return
     */
    public static boolean canJump02(int[] nums){
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}
