package leetCode.tree;

import leetCode.TreeNode;

import java.util.Stack;

/**
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
 * 提示：
 *     给定树中的结点数介于 1 和 100 之间。
 *     每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 */
public class increasingBST_897 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：35.9 MB, 在所有 Java 提交中击败了73.00% 的用户
     */
    TreeNode dummy = new TreeNode(-1);
    TreeNode tmp = dummy;
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return dummy.right;
    }
    private void inOrder(TreeNode root){
        if (root == null) {
            return ;
        }
        inOrder(root.left);

        //单独创建结点（复制结点）消耗空间
        //tmp.right = new TreeNode(root.val);
        //tmp = tmp.right;

        //改变指针的指向
        tmp.right = root;
        root.left = null;
        tmp = root;

        inOrder(root.right);

    }
}
