package leetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class inorderTraversal_94 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {

    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :38.2 MB, 在所有 Java 提交中击败了5.11%的用户
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                inorderTraversal(root.left);
            }
            list.add(root.val);
            if (root.right != null) {
                inorderTraversal(root.right);
            }
        }
        return list;
    }
}
