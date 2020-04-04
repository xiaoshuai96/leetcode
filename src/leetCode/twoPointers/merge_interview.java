package leetCode.twoPointers;

import java.util.Arrays;

/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 */
public class merge_interview {
    public static void main(String[] args) {
        int[] A = {1,2,3,0,0,0};
        int[] B = {2,5,6};
        merge02(A,3,B,3);
        System.out.println(Arrays.toString(A));
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了35.69% 的用户
     * 内存消耗 :38 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param A
     * @param m A数组中空余位置数量
     * @param B
     * @param n B数组中元素数量
     */
    public static void merge01(int[] A,int m,int[] B,int n){
        int count = 0;
        Arrays.sort(A);
        for(int i : A){
            if (i == 0) break;
            count++;
        }
        int temp = 0;
        while (n > 0) {
            A[count++] = B[temp++];
            n--;
        }
        Arrays.sort(A);
    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :37.9 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge02(int[] A,int m,int[] B,int n){
        int p1=m-1;
        int p2=n-1;
        int cur=m+n-1;
        while (p2>=0){
            //A[cur--]=(p1>=0&&B[p2]<A[p1])?A[p1--]:B[p2--];
            if (p1 >= 0 && B[p2] < A[p1]) {
                A[cur--] = A[p1--];
            } else {
                A[cur--] = B[p2--];
            }
        }
    }

}
