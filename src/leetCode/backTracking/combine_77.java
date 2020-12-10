package leetCode.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class combine_77 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new combine_77().combine(4,2);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 执行用时：19 ms, 在所有 Java 提交中击败了52.13% 的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了98.33% 的用户
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n < 1 || k > n) return res;
        backTrack(n,k,1,res,new LinkedList<Integer>());
        return res;
    }
    private void backTrack(int n, int k,int begin,List<List<Integer>> res, LinkedList<Integer> ans) {
        if (ans.size() == k) {
            res.add(new ArrayList<Integer>(ans));
            return ;
        }
        for (int i = begin; i <= n; i++) {
            ans.addLast(i);
            backTrack(n,k,i + 1,res,ans);
            ans.removeLast();
        }
    }

}
