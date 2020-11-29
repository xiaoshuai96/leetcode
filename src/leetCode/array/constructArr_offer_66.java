package leetCode.array;

import java.util.Arrays;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 * 提示：
 *     所有元素乘积之和不会溢出 32 位整数
 *     a.length <= 100000
 */
public class constructArr_offer_66 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] arr = constructArr02(a);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：50.8 MB, 在所有 Java 提交中击败了94.38% 的用户
     * @param a
     * @return
     */
    public static int[] constructArr(int[] a){
        //统计乘积
        int count = 1;
        //统计数组中0的个数
        int countZero = 0;
        for(int i : a) {
            if(i == 0) {
                countZero++;
                continue;
            }
            count *= i;
        }
        //一个数组中0的个数大于1，直接返回整0的数组
        if(countZero > 1) return new int[a.length];
        for(int i = 0;i < a.length;i++) {
            //数组中没有0，那么该位置的数应该是整个数组的乘积除以原来该位置上的数所得的商
            if(countZero == 0){
                a[i] = count / a[i];
            }else {//数组中一个0：除了0个位置上是其他数的乘积，别的位置都是0
                if(a[i] == 0) a[i] = count;
                else a[i] = 0;
            }
        }
        return a;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：51.2 MB, 在所有 Java 提交中击败了43.94% 的用户
     * @param a
     * @return
     */
    public static int[] constructArr02(int[] a){
        int n = a.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= a[i], i++)       /* 从左往右累乘 */
            B[i] = product;
        for (int i = n - 1, product = 1; i >= 0; product *= a[i], i--)  /* 从右往左累乘 */
            B[i] *= product;
        return B;
    }

}
