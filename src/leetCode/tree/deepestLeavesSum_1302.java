package leetCode.tree;

import leetCode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 *
 * 示例：
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 *
 *
 *
 * 提示：
 *     树中节点数目在 1 到 10^4 之间。
 *     每个节点的值在 1 到 100 之间。
 */
public class deepestLeavesSum_1302 {
    //maxDepth:最大深度  total:权值
    int maxDepth = -1,total = 0;
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.26% 的用户
     * 内存消耗：40.5 MB, 在所有 Java 提交中击败了11.64% 的用户
     */
    public int deepestLeavesSum(TreeNode root) {
        dfs(root,0);
        return total;
    }

    /**
     * 深度优先遍历；
     * 算法思路：
     * 如果当前结点为空，直接返回
     * 1.如果当前深度大于最大深度，更新最大深度，并且total变为最大深度的权值
     * 2.如果当前深度等于最大深度，当前结点的val加在total上
     * 3.如果当前深度小于最大深度，直接跳过继续向下遍历
     * @param root
     * @param depth
     */
    private void dfs(TreeNode root,int depth){
        if (root == null) {
            return ;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
            total = root.val;
        } else if (depth == maxDepth) {
            total += root.val;
        }
        dfs(root.left ,depth + 1);
        dfs(root.right,depth + 1);
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了25.40% 的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了84.37% 的用户
     * @param root
     * @return
     */
    public int deepestLeavesSum02(TreeNode root) {
        return bfs(root);
    }

    /**
     * 广度优先搜索
     * 按层遍历树，只需要返回最后一层节点的和即可
     * @param root
     * @return
     */
    private int bfs(TreeNode root){
        if (root == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int sum = 0;
        while (!deque.isEmpty()) {
            sum = 0;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                sum += node.val;
                if(node.left  != null) deque.addLast(node.left);
                if(node.right != null) deque.addLast(node.right);
            }
        }
        return sum;
    }
}
