package leetCode.binarySearch;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class minArray_offer_11 {
    /**
     * 因为数组只进行了一次旋转，那么这个数组会被分为两部分递增的子数组
     * 我们只需要找到最后一个数组的第一个元素即是最小值
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int min = 0;
        for(int i = 1;i < numbers.length; ++i){
            if(numbers[i] < numbers[i - 1])return numbers[i];
        }
        return numbers[0];
    }

    /**
     * binarySearch
     * @param numbers
     * @return
     */
    public int minArray01(int[] numbers){
        int i = 0,j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] < numbers[j]) {
                j = m;
            } else if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else {
                j -= 1;
            }
        }
        return numbers[i];
    }
}
