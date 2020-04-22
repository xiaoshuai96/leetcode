package leetCode.tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class rightSideView_199 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {

    }

    /**
     * 深度优先搜索，按照根结点、右子结点、左子结点的顺序遍历
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root){
        dfs(root,0);
        return list;
    }

    private static void dfs(TreeNode root, int depth) {
        if (root == null) {
            return ;
        }
        if (depth == list.size()) {
            list.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left,depth);
    }

    /**
     * breadthFirstSearch:使用队列的方式来遍历树，将每一层最后一个节点值加入目标集合
     * 执行用时 :1 ms, 在所有 Java 提交中击败了97.36% 的用户
     * 内存消耗 :38.2 MB, 在所有 Java 提交中击败了5.00%的用户
     * @param root
     * @return
     */
    public static List<Integer> rightSideView02(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                //将这一层最后一个节点值加入目标集合中
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
