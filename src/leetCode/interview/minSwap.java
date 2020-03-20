package leetCode.interview;

import java.util.Hashtable;

public class minSwap {
    public static void main(String[] args) {
        int[] A = {3,3,8,9,10};
        int[] B = {1,7,4,6,8};
        int i = minSwap(A, B);
        System.out.println(i);


    }
    public static int minSwap(int[] A,int[] B){
        int count = 0;
        for(int i = 0;i < A.length;i++){
            if((i+1) < A.length && A[i] >= A[i+1]) count++;
        }
        for(int i = 0;i < B.length;i++){
            if((i+1) < B.length && B[i] >= B[i+1]) count++;
        }
        return count;
    }
}
