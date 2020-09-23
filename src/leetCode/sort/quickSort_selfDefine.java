package leetCode.sort;

import java.util.Arrays;

/**
 * 该demo主要实现初级的快速排序算法
 */
public class quickSort_selfDefine {
    public static void main(String[] args) {
        int[] resource = {6,9,4,5,2,0,8,7,3,1,20,56,11,20,8,0,1,3,52,56,45};
        quickSort(resource,0,resource.length-1);
        System.out.println(Arrays.toString(resource));
    }
    public static void quickSort(int[] resource,int low,int high){
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
        quickSort(resource,low,j-1);
        //右边
        quickSort(resource,j+1,high);
    }
}
