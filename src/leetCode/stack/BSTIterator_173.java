package leetCode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 * 示例：
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *
 *
 *
 * 提示：
 *     next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 *     你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 */
public class BSTIterator_173 {
    /**
     * 执行用时：23 ms, 在所有 Java 提交中击败了62.69% 的用户
     * 内存消耗：41.9 MB, 在所有 Java 提交中击败了93.19% 的用户
     */
    private Deque<Integer> stack;
    public BSTIterator_173(TreeNode root) {
        stack = new LinkedList<>();
        preOrder(stack,root);
    }
    public int next() {
        if (!stack.isEmpty()) {
            return stack.pollLast();
        }
        return -1;
    }

    public boolean hasNext() {
        if (!stack.isEmpty()) {
            return true;
        }
        return false;
    }

    private void preOrder(Deque<Integer> stack,TreeNode root){
        if (root == null) {
            return ;
        }
        if (root.right != null) {
            preOrder(stack,root.right);
        }
        stack.addLast(root.val);
        if (root.left != null) {
            preOrder(stack,root.left);
        }
    }
}
