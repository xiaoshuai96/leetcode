package leetCode.tree;

import com.sun.glass.ui.Size;
import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
 * 返回：
 *
 * [3,9,20,15,7]
 *
 * 提示：
 *
 *     节点总数 <= 1000
 */
public class levelOrder_offer_32_I {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.73% 的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了57.12% 的用户
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        bfs(res, root);
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[0] = res.get(i);
        }
//        return res.stream().mapToInt(Integer::intValue).toArray();
        return ans;
    }
    private void bfs(List<Integer> res, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            res.add(node.val);
        }
    }
}
