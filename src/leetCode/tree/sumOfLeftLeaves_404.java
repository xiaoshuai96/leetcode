package leetCode.tree;

import leetCode.TreeNode;

/**
 *计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class sumOfLeftLeaves_404 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：37.1 MB, 在所有 Java 提交中击败了9.78% 的用户
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    public int dfs(TreeNode node) {
        int res = 0;
        //如果该结点的左子结点不为空，res累加（取决于该左子结点是否为叶子结点）
        if (node.left != null) {
            res += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        //如果该节点的右子结点不为空并且不为叶子结点，就接着把该结点传递
        if (node.right != null && !isLeafNode(node.right)) {
            res += dfs(node.right);
        }
        return res;
    }

    /**
     * 判断该结点是否是叶子结点
     * @param node
     * @return
     */
    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
