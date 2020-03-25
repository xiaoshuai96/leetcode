package leetCode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个整数数组nums和index。你需要按照以下规则创建目标数组：
 *     目标数组target最初为空。
 *     按从左到右的顺序依次读取nums[i]和index[i]，
 *     在target数组中的下标index[i]处插入值nums[i] 。
 *     重复上一步，直到在nums和index中都没有要读取的元素。
 *
 * 请你返回目标数组。
 * 题目保证数字插入位置总是存在。
 *
 * 示例 1：
 * 输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * 输出：[0,4,1,3,2]
 * 解释：
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4,0], index = [0,1,2,3,0]
 * 输出：[0,1,2,3,4]
 * 解释：
 * nums       index     target
 * 1            0        [1]
 * 2            1        [1,2]
 * 3            2        [1,2,3]
 * 4            3        [1,2,3,4]
 * 0            0        [0,1,2,3,4]
 *
 * 示例 3：
 * 输入：nums = [1], index = [0]
 * 输出：[1]
 *
 * 提示：
 *
 *     1 <= nums.length, index.length <= 100
 *     nums.length == index.length
 *     0 <= nums[i] <= 100
 *     0 <= index[i] <= i
 */
public class createTargetArray_1389 {
    public static void main(String[] args) {
        createTargetArray(new int[]{1,2,3,4,0},new int[]{0,1,2,3,0});
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了90.70% 的用户
     * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @param index
     * @return
     */
    public static int[] createTargetArray(int[] nums,int[] index){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i],nums[i]);
        }
        int[] res = new int[nums.length];
        int i = 0;
        for (int a : list) {
            res[i++] = a;
        }
        return res;
    }
}
