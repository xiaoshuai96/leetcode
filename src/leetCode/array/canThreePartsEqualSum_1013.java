package leetCode.array;
/**
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 *
 *
 * 示例 1：
 *
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 * 示例 2：
 *
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 *
 * 示例 3：
 *
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 *
 *
 * 提示：
 *
 *     3 <= A.length <= 50000
 *     -10^4 <= A[i] <= 10^4
 */
public class canThreePartsEqualSum_1013 {
    public static void main(String[] args) {
        int[] A = {10,-10,10,-10,10,-10,10,-10};
        boolean b = canThreePartsEqualSum01(A);
        System.out.println(b);
    }

    /**
     * 莫名其妙的100%
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :44.5 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param A
     * @return
     */
    public static boolean canThreePartsEqualSum01(int[] A) {
//        if (A.length < 3) return false;
        int AverSum = 0;
        for (int i = 0; i < A.length; i++) {
            AverSum += A[i];
        }
        AverSum /= 3;
        int temp = 0,count = 0;
        for (int i = 0; i < A.length; i++) {
            temp += A[i];
            if (temp == AverSum) {
                count++;
                temp = 0;
            }
        }
        return count>=3;
    }

    public static boolean canThreePartsEqualSum02(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];//得到整个数组的和
        }
        //temp用来记录每次前n项和是否等于和的1/3  count用来记录两者相等了几次
        int temp = 0,count = 0;
        for (int i = 0; i < A.length; i++) {
            temp += A[i];
            if (temp == (sum/3)) {
                count++;
                temp = 0;
            }
        }
        return count >= 3;
    }
}
