package leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *
 * 提示：
 *
 *     1 <= A.length <= 5000
 *     0 <= A[i] <= 5000
 *
 */
public class sortArrayByParity_905 {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        int[] array = sortArrayByParity01(arr);
        System.out.println(Arrays.toString(array));
    }
    //version 1.0
    public static int[] sortArrayByParity01(int[] A){
        List<Integer> list01 = new ArrayList<>();
        List<Integer> list02 = new ArrayList<>();
        for (int a : A) {
            if (a % 2 == 0) {
                list02.add(a);
            } else {
                list01.add(a);
            }
        }
        int[] arr = new int[list01.size()+list02.size()];
        int di = 0;
        for (int l1 : list02) arr[di++] = l1;
        for (int l2 : list01) arr[di++] = l2;
        return arr;
    }
    //version 2.0
    public static int[] sortArrayByParity02(int[] A){
        int[] ans = new int[A.length];
        int t = 0;

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 0)
                ans[t++] = A[i];

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 1)
                ans[t++] = A[i];

        return ans;
    }
    //version 3.0
    public static int[] sortArrayByParity03(int[] A){
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }
}
