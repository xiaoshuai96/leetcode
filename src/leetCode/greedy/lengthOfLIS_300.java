package leetCode.greedy;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 *
 *     可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 *     你算法的时间复杂度应该为 O(n2) 。
 *  进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 */
public class lengthOfLIS_300 {
    public static void main(String[] args) {

    }

    /**
     * 动态规划+二分查找
     * 执行用时 :1 ms, 在所有 Java 提交中击败了94.79% 的用户
     * 内存消耗 :38 MB, 在所有 Java 提交中击败了5.05%的用户
     * 时间复杂度 O(NlogN)O(NlogN)O(NlogN) ： 遍历 numsnumsnums 列表需 O(N)O(N)O(N)，在每个 nums[i]nums[i]nums[i] 二分法需 O(logN)O(logN)O(logN)。
     * 空间复杂度 O(N)O(N)O(N) ： tailstailstails 列表占用线性大小额外空间。
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }

}
