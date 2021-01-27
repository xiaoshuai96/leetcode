package leetCode.array;

import java.util.Arrays;

/**
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 *
 * 示例：
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *
 *
 * 提示：
 *     1 <= dominoes.length <= 40000
 *     1 <= dominoes[i][j] <= 9
 */
public class numEquivDominoPairs_1128 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了85.51% 的用户
     * 内存消耗：47.7 MB, 在所有 Java 提交中击败了34.77% 的用户
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        //1 <= dominoes[i][j] <= 9，所以最大是99
        int[] cp = new int[100];
        for(int[] arr:dominoes){
            //排序，归为一种
            Arrays.sort(arr);
            //因为后加入的牌可以跟前面所有的牌组队，所以组队的数量就是之前所存在的牌的数量
            ans += cp[arr[0] * 10 + arr[1]]++;
        }
        return ans;
    }
}
