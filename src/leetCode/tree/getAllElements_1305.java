package leetCode.tree;

import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你 root1 和 root2 这两棵二叉搜索树。
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 *
 *
 * 示例 1：
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 *
 * 示例 2：
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * 输出：[-10,0,0,1,2,5,7,10]
 *
 * 示例 3：
 * 输入：root1 = [], root2 = [5,1,7,0,2]
 * 输出：[0,1,2,5,7]
 *
 *
 * 提示：
 *     每棵树最多有 5000 个节点。
 *     每个节点的值在 [-10^5, 10^5] 之间。
 */
public class getAllElements_1305 {
    /**
     * 执行用时：27 ms, 在所有 Java 提交中击败了24.42% 的用户
     * 内存消耗：41 MB, 在所有 Java 提交中击败了85.16% 的用户
     */
    List<Integer> res1 = new ArrayList<>();
    List<Integer> res2 = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        dfs(root1, res1);
        dfs(root2, res2);
        int i = 0,j = 0;
        int size1 = res1.size(),size2 = res2.size();
        while (i < size1 || j < size2) {
            if (i < size1 && j < size2) {
                if (res1.get(i) < res2.get(j)) {
                    res.add(res1.get(i));
                    i++;
                } else {
                    res.add(res2.get(j));
                    j++;
                }
            } else if (i < size1) {
                res.add(res1.get(i));
                i++;
            } else {
                res.add(res2.get(j));
                j++;
            }
        }
        return res;
    }
    private void dfs(TreeNode root,List<Integer> res){
        if (root == null) {
            return ;
        }
        if (root.left != null) {
            dfs(root.left,res);
        }
        res.add(root.val);
        if (root.right != null) {
            dfs(root.right,res);
        }
    }

    /**
     * 执行用时：25 ms, 在所有 Java 提交中击败了31.07% 的用户
     * 内存消耗：41.3 MB, 在所有 Java 提交中击败了60.16% 的用户
     */
    List<Integer> res = new ArrayList<>();
    public List<Integer> getAllElements02(TreeNode root1, TreeNode root2) {
        getElements(root1);
        getElements(root2);
        Collections.sort(res);
        return res;
    }

    public void getElements(TreeNode root) {
        if (root == null) return;
        getElements(root.left);
        res.add(root.val);
        getElements(root.right);
    }
}
