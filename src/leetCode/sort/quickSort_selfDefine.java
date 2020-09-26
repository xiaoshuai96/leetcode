package leetCode.sort;

import java.util.Arrays;

/**
 * 该demo主要实现初级的快速排序算法
 */
public class quickSort_selfDefine {
    public static void main(String[] args) {
        int[] resource = {6,9,4,5,2,0,8,7,3,1,20,56,11,20,8,0,1,3,52,56,45};
        quickSort02(resource,0,resource.length-1);
        System.out.println(Arrays.toString(resource));
    }

    /**
     * 双端扫描
     * @param resource
     * @param low
     * @param high
     */
    public static void quickSort01(int[] resource,int low,int high){
        //i：左哨兵  j：右哨兵  temp:基准点
        int i,j,temp;
        if (low > high) {
            return ;
        }
        i = low;
        j = high;
        temp = resource[low];
        while (i < j) {
            //j先走，找出比temp小的数之后停下来
            while (temp <= resource[j] && i < j) {
                j--;
            }
            //j找到位置之后，i随后从左往右找出比temp大的数
            while (temp >= resource[i] && i < j) {
                i++;
            }
            //还没碰面
            if (i < j) {
                resource[i] ^= resource[j];
                resource[j] ^= resource[i];
                resource[i] ^= resource[j];
            }
        }
        //交换基准点和最后i、j相遇的位置
        resource[low] = resource[i];
        resource[i] = temp;
        //递归调整左边数组的位置
        quickSort01(resource,low,j-1);
        //右边
        quickSort01(resource,j+1,high);
    }
    public static void quickSort02(int[] A, int L, int R){
        if(L < R){
            int pivot = A[L];//最左边的元素作为中轴元素
            //初始化时小于等于pivot的部分，元素个数为0
            //大于pivot的部分，元素个数也为0
            int i = L, j = L+1;
            while(j <= R){
                if(A[j] <= pivot){
                    i++;
                    Swap(A, i, j);
                    j++;//j继续向前，扫描下一个
                }else{
                    j++;//大于pivot的元素增加一个
                }
            }
            //A[i]及A[i]以前的都小于等于pivot
            //循环结束后A[i+1]及它以后的都大于pivot
            //所以交换A[L]和A[i],这样我们就将中轴元素放到了适当的位置
            Swap(A, L, i);
            quickSort02(A, L, i-1);
            quickSort02(A, i+1, R);
        }
    }
    private static void Swap(int[] A,int L,int i){
        int t = A[L];
        A[L] = A[i];
        A[i] = t;
    }
}
