package leetCode.Depth_Breadth_FirstSearch;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最小深度  2.
 */
public class minDepth_111 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.9 MB, 在所有 Java 提交中击败了34.24% 的用户
     * @param root
     * @return
     */
    public int minDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left),minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right),minDepth);
        }
        return minDepth + 1;
    }
}
