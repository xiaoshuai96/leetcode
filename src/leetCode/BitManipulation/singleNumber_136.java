package leetCode.BitManipulation;
/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 *
 * 思路：如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0。
 */
public class singleNumber_136 {
    public static void main(String[] args){
        int[] arr = {2,2,1,3,3};
        System.out.println(singleNumber01(arr));
    }
    public static int singleNumber01(int[] nums) {
        int temp = nums[0];
        for(int i = 1; i < nums.length;i++){
            temp = twoNumber(temp,nums[i]);
        }
        return temp;
    }
    private static int twoNumber(int a,int b){
        return a ^ b;

    }


    public static int singleNumber(int[] nums){
        int temp = nums[0];
        for (int i = 0; i < nums.length; i++) {
            temp ^= nums[i];
        }
        return temp;
    }

}
