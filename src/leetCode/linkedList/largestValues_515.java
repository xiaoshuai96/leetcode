package leetCode.linkedList;

import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 * 示例：
 * 输入:
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 * */
public class largestValues_515 {
    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了76.70% 的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了8.22% 的用户
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        //队列：先入先出
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while(!stack.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = stack.size();
            for(int i = 0;i < size;i++){
                TreeNode tmp = stack.poll();
                max = Math.max(max,tmp.val);
                if(tmp.right != null) stack.offer(tmp.right);
                if(tmp.left != null) stack.offer(tmp.left);
            }
            res.add(max);
        }
        return res;
    }
}
