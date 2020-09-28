package leetCode.Depth_Breadth_FirstSearch;

import leetCode.TreeNode;
import scala.annotation.meta.param;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class flatten_114 {
    static TreeNode temp = new TreeNode(-1);
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        flatten01(root);
        while (root.right != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了5.01% 的用户
     * @param root
     */
    public static void flatten01(TreeNode root){
        if (root == null) return;
        flatten01(root.left);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        flatten01(right);
        root.right = right;
    }

    /**
     *
     *
     * 将 1 的左子树插入到右子树的地方
     *    1
     *     \
     *      2         5
     *     / \         \
     *    3   4         6
     *将原来的右子树接到左子树的最右边节点
     *      1
     *       \
     *        2
     *      /  \
     *     3    4
     *           \
     *            5
     *             \
     *              6
     *将 2 的左子树插入到右子树的地方
     *       1
     *        \
     *         2
     *          \
     *           3     4
     *                  \
     *                   5
     *                    \
     *                     6
     *将原来的右子树接到左子树的最右边节点
     *          1
     *           \
     *            2
     *             \
     *              3
     *               \
     *                4
     *                 \
     *                  5
     *                   \
     *                    6
     */
    public static void flatten02(TreeNode root){
        if (root != null) {
            //左结点为null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                //找到左子树最右边的结点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边结点
                pre.right = root.right;
                //将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                //考虑下一个节点
                root = root.right;
            }
        }
    }

}
