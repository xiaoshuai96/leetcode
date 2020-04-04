package leetCode.twoPointers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 *   注意：答案中不可以包含重复的三元组。
 *
 *   例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 *        满足要求的三元组集合为：
 *        [
 *            [-1, 0, 1],
 *            [-1, -1, 2]
 *        ]
 * */

public class threeSums_15_unfinished {
    public static void main(String[] args){
        int[] array = new int[]{-1, 0, 1, 2, -1, -4};
        //排序之后的数组  -4  -1  -1  0  1  2
        demo(array);
    }

    public static void demo(int sums[]){
        Arrays.sort(sums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < sums.length;i++) {
            for(int j = i+1;j<sums.length;j++){

                    int first = sums[j];
                    int last = sums[sums.length-j];
                    System.out.println(first+" "+last);

                /*if((sums[i]+first+last)==0){
                    System.out.println(sums[i]+"    "+sums[j]+"     "+sums[sums.length-j]);
                }*/
            }
        }
    }
}
