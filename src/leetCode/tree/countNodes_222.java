package leetCode.tree;

import leetCode.TreeNode;

/**
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 */
public class countNodes_222 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：40.7 MB, 在所有 Java 提交中击败了96.09% 的用户
     * @param root
     * @return
     */
    public int countNodes01(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left  = countNodes01(root.left);
        int right = countNodes01(root.right);
        return left + right + 1;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：40.9 MB, 在所有 Java 提交中击败了87.12% 的用户
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left  = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            return countNodes(root.right) + (1 << left);
        }else{
            return countNodes(root.left ) + (1 << right);
        }
    }
    private int countLevel(TreeNode root){
        int level = 0;
        while(root != null){
            level++;
            root = root.left;
        }
        return level;
    }
}
