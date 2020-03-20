package leetCode.array;
/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class majorityElement_169 {
    public static void main(String[] args) {
        int arr[] = {1,2,2};
        System.out.println(majorityElement01(arr));
    }
    public static int majorityElement02(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public static int majorityElement01(int[] nums){
        if(nums.length==1)return nums[0];
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],1);
        int temp = 1;//记录value
        int res = 0;
        for (int i = 1 ; i < nums.length ; i ++) {
            //如果map中存在key，就将其加入map，并且map对应的value++，否则直接加入map，value初始值为1
            if (map.containsKey(nums[i])) {
                Integer integer = map.get(nums[i]);
                map.remove(nums[i]);
                map.put(nums[i],integer+1);
            }else {
                map.put(nums[i], 1);
            }
            //如果该key对应的value大于temp值，就将这个值赋给temp，并且res拿到该key
            if (map.get(nums[i]) > temp) {
                temp = map.get(nums[i]);
                res = nums[i];
            }

        }
        return res;


    }
}
