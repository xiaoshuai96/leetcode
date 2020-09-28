package leetCode.tree;

import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 *
 *
 * 二叉树的前序遍历顺序：根结点、
 * 这里使用到了stack，利用栈的特性来进行压入和弹出
 * */
public class preorderTraversal_144 {
    public static void main(String[] args) {

    }

    /**
     * 迭代版本
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：37.5 MB, 在所有 Java 提交中击败了5.08% 的用户
     * @param root
     * @return
     */
    public static List<Integer> preTraversal01(TreeNode root){
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        LinkedList<TreeNode> stack = new LinkedList<>();
        //首先将根结点压入栈中
        stack.push(root);
        while (!stack.isEmpty()) {
            //取出栈顶的结点
            TreeNode temp = stack.pollLast();

            //先将结点的value加入list中
            list.add(temp.val);

            //再判断该节点的左右子树是否为空，如果不为空就将当前结点的左子树或者右子树加入栈中
            //为什么先遍历右节点，因为栈的特性（先入后出），我们的遍历是前序遍历
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return list;
    }

    static List<Integer> res = new ArrayList<>();

    /**
     * 递归版本
     * @param root
     * @return
     */
    public static List<Integer> preTraversal02(TreeNode root){
        dfs(root);
        return res;
    }
    private static void dfs(TreeNode root){
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
    }
}
