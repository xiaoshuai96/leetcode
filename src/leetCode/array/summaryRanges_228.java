package leetCode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，
 * 并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *     "a->b" ，如果 a != b
 *     "a" ，如果 a == b
 *
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * 示例 2：
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 * 示例 3：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：["-1"]
 *
 * 示例 5：
 * 输入：nums = [0]
 * 输出：["0"]
 *
 * 提示：
 *     0 <= nums.length <= 20
 *     -2^31 <= nums[i] <= 2^31 - 1
 *     nums 中的所有值都互不相同
 *     nums 按升序排列
 */
public class summaryRanges_228 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        List<String> list = new summaryRanges_228().summaryRanges(nums);
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了85.32% 的用户
     * 内存消耗：36.8 MB, 在所有 Java 提交中击败了66.82% 的用户
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> res = new ArrayList<>();
        if (len == 0) return res;
        int start = nums[0],end = nums[0];
        for (int i = 1; i <= len; i++) {
            //如果i小于len并且相邻两个元素之间连续
            if (i < len && nums[i] - nums[i - 1] == 1) {
                end = nums[i];
            } else {
                //如果end和start不同，说明连续的数不止一个，将起始和终止的数加入res
                if (end != start) {
                    res.add(start + "->" + end);
                } else {
                    //否则说明连续的数只有一个start
                    res.add(String.valueOf(start));
                }
                if (i == len) return res;
                start = nums[i];
                end = nums[i];
            }
        }
        return res;
    }
}
