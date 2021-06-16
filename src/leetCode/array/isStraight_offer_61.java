package leetCode.array;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 限制：
 * 数组长度为 5
 * 数组的数取值为 [0, 13] .
 */
public class isStraight_offer_61 {
    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6};
        new isStraight_offer_61().isStraight(nums);
    }

    /**
     * 在给出的五个数中，找出最大值max和最小值min（除过大小王），如果max - min的个数小于5，说明是可以组成顺子的
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int kingOfNum = 0,lastKingIndex = 0;
        for(int i = 0;i < 4;i++){
            if(nums[i] == 0) kingOfNum++;
            else if (nums[i] == nums[i + 1]) return false;
        }
        return nums[4] - nums[lastKingIndex] < 5;
    }
}
