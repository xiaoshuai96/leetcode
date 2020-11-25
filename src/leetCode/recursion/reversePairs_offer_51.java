package leetCode.recursion;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 限制：
 * 0 <= 数组长度 <= 50000
 *
 * hard
 */
public class reversePairs_offer_51 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：40 ms, 在所有 Java 提交中击败了33.14% 的用户
     * 内存消耗：47.1 MB, 在所有 Java 提交中击败了92.69% 的用户
     *
     * 该算法的思想为：分治
     * 我们一直对数组进行拆分，一直到子数组中剩余一个元素无法拆分的时候停止
     * 这个时候，每个子数组都是有序的，那么什么时候开始计算逆序对的个数呢？
     * 这个过程就在网上归并的过程中
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int len = nums.length;
        //不构成数对的情况
        if (len < 2) {
            return 0;
        }
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy,0,len - 1,temp);
    }

    /**
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs  = reversePairs(nums,left,mid,temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        int crossPairs = mergeAndCount(nums,left,mid,right,temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
