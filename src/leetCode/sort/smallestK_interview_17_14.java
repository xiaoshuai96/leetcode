package leetCode.sort;

import java.util.Arrays;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 *
 * 提示：
 *
 *     0 <= len(arr) <= 100000
 *     0 <= k <= min(100000, len(arr))
 */
public class smallestK_interview_17_14 {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,2,4,3,5};
        new smallestK_interview_17_14().smallestK(arr,5);

    }

    public int[] smallestK(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    /**每分区一次就去check j和k的关系
     * 如果j == k ,说明现在j的左边都是小于j的，那么j左边的子数组就是最终结果
     * 如果j > k  ,说明现在的j所求出的范围已经超出了需要的目标子数组的长度（并不需要那么多），那么我们就左移right
     * 否则，就将left右移
     * @param nums
     * @param lo
     * @param hi
     * @param k
     * @return
     */
    public int[] quickSearch(int[] nums,int lo,int hi,int k){
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        return j < k ? quickSearch(nums, j + 1, hi, k) : quickSearch(nums, lo, j - 1, k);
    }
    //使用快速排序法进行切分，返回j，表示小于nums[j]都在j的左边，大于nums[j]的都在j的右边
    public int partition(int[] nums,int lo,int hi){
        int v = nums[lo];//暂存标志位
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i >= j) {
                break;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }
}
