package leetCode.Depth_Breadth_FirstSearch;

import java.util.LinkedList;
import java.util.List;
import leetCode.TreeNode;
/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 提示：
 *     节点总数 <= 10000
 */
public class pathSum_offer_34 {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    private void recur(TreeNode root, int tar) {
        if(root == null) return;
        path.add(root.val);
        tar -= root.val;
        //目标数值为0 并且当前结点为叶子节点，则将该路径加入res中
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList(path));
        }
        //左右子树开始遍历
        recur(root.left, tar);
        recur(root.right, tar);
        //向上回溯时，将当前结点从路径中移除
        path.removeLast();
    }
}
