package leetCode.tree;

import leetCode.TreeNode;

import java.util.Stack;

/**
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class isValidBST_interview_0405 {
    public static void main(String[] args) {

    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean helper(TreeNode root,long min,long max){
        return root == null ||
                (
                    root.val > min
                    && root.val < max
                    && helper(root.left, min, root.val)
                    && helper(root.right, root.val, max)
                );
    }

    /**
     * 解题思路：如果一个树是二叉搜索树，那么它的中序遍历结果，它的val一定是严格递增的
     * 所以我们可以在中序遍历过程中记录每个结点上个被遍历结点的值，只要整体保证前者大于后者，那么该树就是二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST02(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double lastVal = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= lastVal) {
                return false;
            }
            lastVal = root.val;
            root = root.right;
        }
        return true;
    }

}
