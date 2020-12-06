package leetCode.tree;

import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 提示：
 *
 *     节点总数 <= 1000
 */
public class levelOrder_offer_32_II {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> stack = new LinkedList<TreeNode>();
        if (root == null) {
            return res;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> tmp = new ArrayList<Integer>(size);
            //根据当前队列的大小指定此次弹出的元素个数
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.poll();
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
                tmp.add(node.val);
            }
            res.add(tmp);
        }
        return res;
    }
}
