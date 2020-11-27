package leetCode.array;

/**
 * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，
 * 使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 说明：
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下：
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * 示例 1：
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 提示：
 *     0 <= nums.length <= 3 * 104
 *     -10^4 <= nums[i] <= 10^4
 *     nums 按递增顺序排列
 */
public class removeDuplicates_80 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int i = removeDuplicates(arr);
        System.out.println(i);
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了92.57% 的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了49.30% 的用户
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) return len;
        if (nums[0] == nums[len - 1]) return 2;
        //既然是递增排列，将数组的大小设置为最大值减去最小值加1即可
        int ansLen = Math.abs(nums[0]) + Math.abs(nums[len - 1]) + 1;
        int[] ans = new int[ansLen];
        for(int i : nums){
            //最多只存两个相同的数
            if (ans[i - nums[0]] < 2) {
                ans[i - nums[0]]++;
            }
        }
        int index = 0;
        for (int i = 0; i < ansLen; i++) {
            if (ans[i] != 0) {
                int c = ans[i];
                while (c != 0) {
                    nums[index++] = (i + nums[0]);
                    c--;
                }
            }
        }
        return index;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了91.09% 的用户
     * towPointers
     *
     * @param nums
     * @return
     */
    public int removeDuplicates02(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }
}
