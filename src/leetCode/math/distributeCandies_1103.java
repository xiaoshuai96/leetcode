package leetCode.math;

import java.util.Arrays;

public class distributeCandies_1103 {
    public static void main(String[] args) {
        int candies = 60,num_people = 4;
        int[] arr = distributeCandies01(candies, num_people);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了90.51% 的用户
     * 内存消耗 :36.7 MB, 在所有 Java 提交中击败了5.27%的用户
     * @param candies
     * @param num_people
     * @return
     */
    public static int[] distributeCandies01(int candies,int num_people){
        int[] child = new int[num_people];
        int tmp = 1,count = 0;
        //直至糖果数为0
        while (candies != 0) {
            tmp = count * child.length;
            for(int i = 0;i < child.length;i++){
                if (candies <= tmp+(i+1)) {
                    child[i] += candies;
                    return child;
                }
                child[i] += tmp +(i+1);
                candies -= tmp  +(i+1);
            }
            count++;
        }
        return child;
    }

    /**
     * 官方暴力法
     * 执行用时 :3 ms, 在所有 Java 提交中击败了8.10% 的用户
     * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了5.27%的用户
     * @param candies
     * @param num_people
     * @return
     */
    public static int[] distributeCandies02(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i = 0;
        while (candies != 0) {
            ans[i % num_people] += Math.min(candies, i + 1);
            candies -= Math.min(candies, i + 1);
            i += 1;
        }
        return ans;
    }
}
