package leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你一个以行程长度编码压缩的整数列表 nums 。
 *
 * 考虑每对相邻的两个元素 freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），
 * 每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
 *
 * 请你返回解压后的列表。
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[2,4,4,4]
 * 解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
 * 第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
 * 最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
 *
 * 示例 2：
 *
 * 输入：nums = [1,1,2,3]
 * 输出：[1,3,3]
 *
 *
 * 提示：
 *
 *     2 <= nums.length <= 100
 *     nums.length % 2 == 0
 *     1 <= nums[i] <= 100
 */
public class decompressRLElist_1313 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3};
        int[] ints = decompressRLElist02(arr);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 执行用时 :5 ms, 在所有 Java 提交中击败了46.32% 的用户
     * 内存消耗 :41.3 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @return
     */
    public static int[] decompressRLElist(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                list.add(nums[i+1]);
            }
        }
        int count = 0;
        int[] res = new int[list.size()];
        for (int a : list) {
            res[count++] = a;
        }
        return res;
    }

    /**
     * 给定数组的偶数位相加即得到需要返回数组的大小
     * 执行用时 :2 ms, 在所有 Java 提交中击败了68.16% 的用户
     * 内存消耗 :40.9 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @return
     */
    public static int[] decompressRLElist02(int[] nums) {
        int resLength = 0;
        for (int i = 0; i < nums.length; i+=2) {
            resLength += nums[i];
        }
        int[] res = new int[resLength];
        int count = 0;
        for (int i = 0; i < nums.length; i += 2) {
            while (nums[i] != 0) {
                res[count++] = nums[i+1];
                nums[i]--;
            }
        }
        return res;
    }
}
