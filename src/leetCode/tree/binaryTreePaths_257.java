package leetCode.tree;

import leetCode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class binaryTreePaths_257 {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了99.95% 的用户
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        constructPaths(root, "", res);
        return res;
    }
    private void constructPaths(TreeNode root,String path,List<String> paths){
        if (root != null) {
            StringBuffer sbPaths = new StringBuffer(path);
            sbPaths.append(root.val);
            //遇到叶子节点，表示该条路径已形成，加入结果集即可
            if (root.left == null && root.right == null) {
                paths.add(sbPaths.toString());
            } else {
                //否则，在路径中叠加，分别向左右子树进行递归
                sbPaths.append("->");
                constructPaths(root.left, sbPaths.toString(), paths);
                constructPaths(root.right, sbPaths.toString(), paths);
            }

        }
    }
}
