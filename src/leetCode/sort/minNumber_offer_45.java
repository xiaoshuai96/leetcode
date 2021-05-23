package leetCode.sort;

import java.util.Arrays;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 *
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * 提示:
 *     0 < nums.length <= 100
 *
 * 说明:
 *     输出结果可能非常大，所以你需要返回一个字符串而不是整数
 *     拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */
public class minNumber_offer_45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x,y) -> (x + y).compareTo(y + x));
        StringBuffer res = new StringBuffer();
        for(String s : strs){
            res.append(s);
        }
        return res.toString();
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了97.16% 的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了75.18% 的用户
     * @param nums
     * @return
     */
    public String minNumber02(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
    private void quickSort(String[] strs,int l,int r){
        if (l >= r) {
            return ;
        }
        int i = l,j = r;
        String tmp = strs[i];
        while (i < j) {
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }
}
