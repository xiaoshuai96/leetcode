package leetCode.tree;
import leetCode.TreeNode;
/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 *
 * 示例 3：
 * 输入：root = []
 * 输出：true
 *
 *
 * 提示：
 *     树中的节点数在范围 [0, 5000] 内
 *     -10^4 <= Node.val <= 10^4
 */
public class isBalanced_110 {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }
    private int height(TreeNode root) {
        if(root == null) return 0;
        int lh = height(root.left), rh = height(root.right);
        //如果左树高度大于等于0 并且右树高度大于等于0 左右子树高度差小于等于1，则返回父节点的最大高度
        if(lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1) {
            return Math.max(lh, rh) + 1;
        } else {//否则返回-1，代表非高度平衡二叉树
            return -1;
        }
    }
}
