package leetCode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 *
 * 示例 1：
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 *
 * 示例 4：
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 *
 * 提示：
 *     1 <= A.length <= 10000
 *     1 <= B.length <= 10000
 *     1 <= A[i] <= 100000
 *     1 <= B[i] <= 100000
 *     保证爱丽丝与鲍勃的糖果总量不同。
 *     答案肯定存在。
 */
public class fairCandySwap_888 {
    /**
     * 无脑暴力！
     * 执行用时：504 ms, 在所有 Java 提交中击败了11.73% 的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了70.81% 的用户
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int aCount = 0;
        int bCount = 0;
        for(int i : A) aCount += i;
        for(int i : B) bCount += i;
        for(int i = 0;i < A.length;i++){
            for(int j = 0;j < B.length;j++){
                if(A[i] == B[j])continue;
                if((aCount - A[i] + B[j]) == (bCount - B[j] + A[i])){
                    return new int[]{A[i],B[j]};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 什么情况下会满足题意呢？
     * 假设存在x，y，前者属于A中元素，后者属于B中元素
     * 数组A的总和为Asum
     * 数组B的总和为Bsum
     * 当 Asum - x + y = Bsum - y + x时，这时的x和y是否和要求的一对解
     * 上面的式子可以变形为
     * y = (Bsum - Asum) / 2  +  x
     * 我们可以使用一个集合来存储B数组中的所有元素，然后遍历A数组中的元素，每次计算上面式子右半部分，与集合中的元素进行比较，
     * 如果遇见相同的元素，则当前x和y是一对解
     *
     *
     * 执行用时：16 ms, 在所有 Java 提交中击败了36.21% 的用户
     * 内存消耗：40.4 MB, 在所有 Java 提交中击败了35.75% 的用户
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap02(int[] A, int[] B) {
        int Asum = Arrays.stream(A).sum();
        int Bsum = Arrays.stream(B).sum();
        int ans = (Bsum - Asum) / 2;
        Set<Integer> set = new HashSet<>();
        for(int y : B){
            set.add(y);
        }
        int[] res = new int[2];
        for(int x : A){
            int y = ans + x;
            if (set.contains(y)) {
                res[0] = x;
                res[1] = y;
                break;
            }
        }
        return res;
    }

}
