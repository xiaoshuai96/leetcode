package leetCode.BitManipulation;

/**
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 *
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 * 示例:
 *
 * 输入: 4, 14, 2
 *
 * 输出: 6
 *
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 *
 * 注意:
 *
 *     数组中元素的范围为从 0到 10^9。
 *     数组的长度不超过 10^4。
 *
 */
public class totalHammingDistance_477 {
    public static void main(String[] args) {
        int[] nums = {4,14,2};
        int i = totalHammingDistance(nums);
        System.out.println(i);
    }

    /**
     * 暴力法，超出时间限制
     * @param nums
     * @return
     */
    public static int totalHammingDistance(int[] nums){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                count += cal(nums[i],nums[j]);
            }
        }
        return count;
    }
    private static int cal(int a,int b){
        int count = 0;
        int res = a ^ b;
        while (res != 0){
             count = (res % 2 == 1 ? count+1 : count);
             res /= 2;
        }
        return count;
    }

    public static int totalHammingDistance02(int[] nums){
        int res = 0;
        int len = nums.length;
        for(int i = 0; i < 30; i++){
            int oneCount = 0;
            int temp = 0;
            for(int j = 0; j < len; j++){
                oneCount += nums[j] & 1;
                nums[j] >>= 1;
                temp += nums[j] == 0 ? 1 : 0;
            }
            res += oneCount * (len - oneCount);
            if(temp == len)break;
        }
        return res;
    }
}
