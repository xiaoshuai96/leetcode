package leetCode.recursion;

import java.util.Arrays;

/**
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 *
 * 示例：
 *
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 *
 * 提示：
 *
 *     0 < shorter <= longer
 *     0 <= k <= 100000
 */
public class divingBoard_interview_16_11 {
    public static void main(String[] args) {

    }

    /**
     * 非递归版本
     * 执行用时：7 ms, 在所有 Java 提交中击败了17.42% 的用户
     * 内存消耗：48.4 MB, 在所有 Java 提交中击败了100.00% 的用户
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public static int[] divingBoard(int shorter,int longer,int k){
        if(k <= 0) return new int[]{};
        if(longer == shorter) return new int[]{shorter * k};
        int[] res = new int[k + 1];
        res[0] = shorter * k;
        res[1] = longer * k;
        int start = 1,end = k - 1;
        for(int i = 2;i < res.length;i++){
            res[i] = longer * (start++) + shorter * (end--);
        }
        Arrays.sort(res);
        return res;
    }
}
