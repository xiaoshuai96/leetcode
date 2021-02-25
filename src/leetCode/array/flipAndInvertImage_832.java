package leetCode.array;
/**
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 示例 1:
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * 示例 2:
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 * 说明:
 *     1 <= A.length = A[0].length <= 20
 *     0 <= A[i][j] <= 1
 */
public class flipAndInvertImage_832 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了7.67% 的用户
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0;i < A.length;i++){
            filpAndReverse(A[i]);
        }
        return A;
    }
    private void filpAndReverse(int[] nums){
        int left = 0,right = nums.length - 1,mid = (right + 1) / 2;
        //判断nums数组的长度是奇数还是偶数，如果是奇数，提前将中间元素反转
        if((right + 1) % 2 == 1) nums[mid] = nums[mid] == 0 ? 1 : 0;
        while(left < right){
            //反转
            nums[left]   = nums[left] == 0 ? 1 : 0;
            nums[right] = nums[right] == 0 ? 1 : 0;
            //翻转
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            ++left;
            --right;
        }
    }



    public int[][] flipAndInvertImage02(int[][] A) {
        int C = A[0].length;
        for (int[] row: A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }

        return A;
    }
}
