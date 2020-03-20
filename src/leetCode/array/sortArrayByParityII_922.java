package leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 * 提示：
 *
 *     2 <= A.length <= 20000
 *     A.length % 2 == 0
 *     0 <= A[i] <= 1000
 *
 */
public class sortArrayByParityII_922 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] array = sortArrayByParityII01(arr);
        System.out.println(Arrays.toString(array));
    }

    //version 1.0 虽说功能可以实现，但是消耗内存太大和运行时间久。
    public static int[] sortArrayByParityII01(int[] A) {
        List<Integer> odd = new ArrayList<>(A.length/2);
        List<Integer> even = new ArrayList<>(A.length/2);
        for (int a : A) {
            if (a % 2 == 0) {
                even.add(a);
                continue;
            }
            odd.add(a);
        }
        int l1 = 0, l2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0){ A[i] = even.get(l2++);}
            if (i % 2 == 1){ A[i] = odd.get(l1++);}
        }
        return A;
    }

    //version 2.0 使用数组解决问题，创建一个新的数组，在遍历旧数组的时候，将每个数依次赋值给新数组中符合下标的位置
    public static int[] sortArrayByParityII02(int[] A){
        int[] arr = new int[A.length];
        int t = 0;
        for (int i : A) if (i % 2 == 0) {
            arr[t] = i;
            t += 2;
        }

        t = 1;
        for (int i : A) if (i % 2 == 1) {
            arr[t] = i;
            t += 2;
        }
        return arr;
    }

    //version 2.1 相比于2.0，速度方面有提升，但是内存消耗会大一点点。
    public static int[] sortArrayByParityII03(int[] A){
        int[] arr = new int[A.length];
        int t1 = 0;
        int t2 = 1;
        for (int i : A) {
            if (i % 2 == 0) {
                arr[t1] = i;
                t1 += 2;
                continue;
            }
            arr[t2] = i;
            t2 += 2;
        }
        return arr;
    }
    //version 3.0 双指针  最优解法
    public static int[] sortArrayByParityII04(int[] A){
        int odd = 1,even = 0;
        for (; even < A.length; even += 2) {
            if ((A[even]&1) == 1) {//偶数下标上的奇数
                while ((A[odd]&1) == 1) {//终止条件：找到奇数下标下的偶数
                    odd += 2;
                }
                A[even] = A[even] ^ A[odd];
                A[odd]  = A[even] ^ A[odd];
                A[even] = A[even] ^ A[odd];
            }
        }
        return A;
    }
}
