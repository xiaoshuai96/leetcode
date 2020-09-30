package leetCode.tree;

import leetCode.TreeNode;

import java.util.Stack;

/**
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 *
 * 例如,
 * 给定二叉搜索树:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 *
 * 或者这个树也是有效的:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 * 提示：
 *
 *     给定的树上的节点数介于 0 和 10^4 之间
 *     每个节点都有一个唯一整数值，取值范围从 0 到 10^8
 *     -10^8 <= val <= 10^8
 *     新值和原始二叉搜索树中的任意节点值都不同
 */
public class insertIntoBST_701 {
    /**
     * 递归版本
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root,int val){
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left  = insertIntoBST(root.left,val);
        }
        return root;
    }

    /**
     * 迭代版本
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了51.24% 的用户
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST02(TreeNode root,int val){
        if (root == null) {
            return new TreeNode(val);
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            if (val > tmp.val) {
                if (tmp.right == null) {
                    tmp.right = new TreeNode(val);
                    break;
                } else {
                    stack.push(tmp.right);
                }
            } else {
                if (tmp.left == null) {
                    tmp.left = new TreeNode(val);
                    break;
                } else {
                    stack.push(tmp.left);
                }
            }
        }
        return root;

    }
}
