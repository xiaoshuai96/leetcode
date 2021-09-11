package leetCode.sort;

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
 * 而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 */
public class findKthLargest_215 {
    public static void main(String[] args) {

    }

    /**
     * 调用API这种，对于基础算法来说还是少用，可以多写写快排
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest02(int[] nums,int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }


    public int findKthLargest(int[] nums, int k) {
        int i = quickSearch(nums,0,nums.length - 1,k - 1);
        return nums[i];
    }
    //检索是否找到了目标值，找到了直接返回，否则根据返回值和目标值的关系继续递归
    private int quickSearch(int[] nums,int lo,int hi,int k){
        int j = partition(nums,lo,hi);
        if(j == k){
            return j;
        }
        return j < k ? quickSearch(nums,j + 1,hi,k) : quickSearch(nums,lo,j - 1,k);
    }
    //快排思想将数组进行分区
    private int partition(int[] nums,int lo,int hi){
        int v = nums[lo];
        int i = lo,j = hi + 1;
        while(true){
            //DESC
            while(++i <= hi && nums[i] > v);
            while(--j >= lo && nums[j] < v);
            if(i >= j){
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
