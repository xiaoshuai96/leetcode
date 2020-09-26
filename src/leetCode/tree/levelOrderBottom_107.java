package leetCode.tree;

import leetCode.TreeNode;

import javax.jnlp.IntegrationService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class levelOrderBottom_107 {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.25% 的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了31.59% 的用户
     * @param root
     * @return
     *
     * 思路：我们还是正常的自顶向下去遍历整棵树，只不过将最终的结果逆序呈现就可以了
     * 首先返回的集合类型是链表形式的集合LinkedList，我们在每次添加每一层遍历完的结果的时候只需要将它添加到
     * 头节点的部分即可
     *
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        //使用队列来存储每一层树的节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //直到队列中没有树的节点为止
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int count = queue.size();
            //当前队列中存在几个节点就循环几次
            for (int i = 0; i < count; i++) {
                //每次循环从队列中弹出一个节点，将值添加到temp集合中
                TreeNode node = queue.poll();
                temp.add(node.val);
                //然后判断该节点是否还有左右节点，如果有，就将左结点或者右节点加入队列，下一次继续判断
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //树的一层遍历结束，将遍历的结果加入结果集中
            res.addFirst(temp);
        }
        return res;
    }
}
