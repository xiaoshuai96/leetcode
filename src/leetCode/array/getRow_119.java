package leetCode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class getRow_119 {
    public static void main(String[] args) {
        List<Integer> row = getRow(3);
        for (Integer integer : row) {
            System.out.print(integer+"\t");
        }
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了40.65% 的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了37.77% 的用户
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> resouce = new ArrayList<>();
        if (rowIndex == 0) {
            resouce.add(1);
            return resouce;
        }
        List<List<Integer>> list = new ArrayList<>();
        resouce.add(1);resouce.add(1);
        list.add(resouce);
        rowIndex--;
        while (rowIndex != 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            List<Integer> ans = list.get(list.size() - 1);
            for (int i = 1;i < ans.size();i++){
                temp.add(ans.get(i) + ans.get(i - 1));
            }
            temp.add(1);
            list.add(temp);
            rowIndex--;
        }
        return list.get(list.size() - 1);
    }

    /**
     * DP
     * 执行用时：1 ms, 在所有 Java 提交中击败了79.19% 的用户
     * 内存消耗：36 MB, 在所有 Java 提交中击败了94.57% 的用户
     * @param N
     * @return
     */
    public List<Integer> getRow02(int N) {
        List<Integer> res = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            res.add(1);
            for (int j = i - 1; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }
}
