package leetCode.twoPointers;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * 进阶：
 *
 *     一个直观的解决方案是使用计数排序的两趟扫描算法。
 *     首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 *     你能想出一个仅使用常数空间的一趟扫描算法吗?
 */
public class sortColors_75 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * towPointers
     * 共遍历三遍：
     * 1.第一遍先把0全部放到数组的第一部分
     * 2.第二遍把1……
     * 3.第三遍把2……
     *
     *
     * 2,0,2,1,1,0
     *
     *
     * 0  0  2  1  1  2
     * 0  0  2  2  1  1
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：37.4 MB, 在所有 Java 提交中击败了37.62% 的用户
     * @param nums
     */
    public static void sortColors(int[] nums){
        if (nums.length == 0 || nums == null) {
            return ;
        }
        int left = 0,right = nums.length - 1;
        //共遍历三次
        for (int i = 0; i < 3; i++) {
            while (left < right) {
                //如果左指针指向的数等于或者小于当前的i，那就进行下一轮，因为小于等于的都是被排好的
                if (nums[left] == i || nums[left] < i) {
                    left++;
                    continue;
                }
                //如果右指针指向的位置是当前轮数的i，那么就交换left和right分别指向的数
                if (nums[right] == i) {
                    int temp = nums[left];
                    nums[left] = i;
                    nums[right] = temp;
                    left++;
                    right--;
                //如果左指针和右指针都不等于当前轮数i，那么就让右指针向左走再判断
                } else if (nums[left] != i && nums[right] != i) {
                    right--;
                //如果左右指针指向的数都是当前轮数i，那么左指针向右一步
                } else if (nums[left] == i && nums[right] == i) {
                    left++;
                }
            }
            //每一轮循环结束之后，右指针回到数组最右边的位置
            right = nums.length - 1;
        }
    }
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：37.4 MB, 在所有 Java 提交中击败了28.95% 的用户
     * @param nums
     */
    public static void sortColors01(int[] nums){
        if (nums.length == 0 || nums == null) {
            return;
        }
        //a : 0  b : 1  c : 2
        int a = 0,b = 0,c = 0 ;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) a++;
            else if (nums[i] == 1) b++;
            else if (nums[i] == 2) c++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (a != 0) {
                nums[i] = 0;
                a--;
            } else if (b != 0) {
                nums[i] = 1;
                b--;
            } else if (c != 0) {
                nums[i] = 2;
                c--;
            }
        }
    }
}
