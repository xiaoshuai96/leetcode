package leetCode.tree;

import leetCode.TreeNode;

/**
 * Given two binary trees original and cloned and given a reference to a node target in the original tree.
 *
 * The cloned tree is a copy of the original tree.
 *
 * Return a reference to the same node in the cloned tree.
 *
 * Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
 *
 * Follow up: Solve the problem if repeated values on the tree are allowed.
 *
 */
public class getTargetCopy_1379 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(19);

    }
    /**
     *
     * @param original
     * @param cloned
     * @param target
     * @return
     */
    public final TreeNode getTargetCopy(final TreeNode original,
                                        final TreeNode cloned, final TreeNode target) {
        if(original == null){
            return null;
        }
        if (original == target) {
            return cloned;
        }
        TreeNode res = getTargetCopy(original.left,cloned.left,target);
        if(res != null){
            return res;
        }
        res = getTargetCopy(original.right,cloned.right,target);
        if(res != null){
            return res;
        }
        return null;
    }
}
