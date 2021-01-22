package leetCode.array;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * 示例 1：
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 *
 * 示例 2：
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 *
 * 示例 3：
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 *
 * 示例 4：
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *
 *
 * 提示：
 *     1 <= A.length <= 10000
 *     0 <= A[i] <= 9
 *     0 <= K <= 10000
 *     如果 A.length > 1，那么 A[0] != 0
 */
public class addToArrayForm_989 {
    public static void main(String[] args) {
        int[] A = {1};
        List<Integer> list = new addToArrayForm_989().addToArrayForm(A, 34);
        for (Integer i : list) {
            System.out.print(i+"\t");
        }
    }

    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了17.66% 的用户
     * 内存消耗：40.4 MB, 在所有 Java 提交中击败了25.70% 的用户
     * @param A
     * @param K
     * @return
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        String sk = String.valueOf(K);
        int alen = A.length - 1;
        int klen = sk.length() - 1;
        int carry = 0;
        List<Integer> res = new LinkedList<>();
        while (alen >= 0 || klen >= 0) {
            int tmp;
            if (alen >= 0 && klen >= 0) {
                tmp = A[alen] + (sk.charAt(klen) - '0') + carry;
                --alen;
                --klen;
            } else if (alen >= 0) {
                tmp = A[alen] + carry;
                --alen;
            } else {
                tmp = sk.charAt(klen) - '0' + carry;
                --klen;
            }
            res.add(tmp % 10);
            carry = tmp / 10;
        }
        if (carry != 0) res.add(carry);
        Collections.reverse(res);
        return res;
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了98.45% 的用户
     * 内存消耗：40.7 MB, 在所有 Java 提交中击败了11.53% 的用户
     * @param A
     * @param K
     * @return
     */
    public List<Integer> addToArrayForm02(int[] A, int K) {
        int len = A.length;
        int lastNum = K;
        LinkedList<Integer> ret = new LinkedList<>();
        //从数组A和k的末尾开始遍历
        int i = len - 1;
        while(i >=0 || lastNum > 0){
            if(i >= 0){
                lastNum += A[i];
            }
            ret.addFirst(lastNum % 10);
            lastNum /= 10;
            i--;
        }
        return ret;
    }
}
