package leetCode.tree;

import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表
 * （比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 * 示例：
 * 输入：[1,2,3,4,5,null,7,8]
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 * 输出：[[1],[2,3],[4,5,7],[8]]
 */
public class listOfDepth_interview_0403 {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了97.11% 的用户
     * 内存消耗：36.7 MB, 在所有 Java 提交中击败了79.29% 的用户
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return new ListNode[]{};
        List<ListNode> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            int size = stack.size();
            ListNode dummy = new ListNode(-1);
            ListNode temp = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pollFirst();
                temp.next = new ListNode(node.val);
                temp = temp.next;
                if (node.left  != null) stack.addLast(node.left);
                if (node.right != null) stack.addLast(node.right);
            }
            res.add(dummy.next);
        }
        return res.toArray(new ListNode[res.size()]);
    }
}
