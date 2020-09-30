package leetCode.tree;

import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 *
 * */
public class postorderTraversal_145 {
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {

    }
    public static List<Integer> postorderTraversal(Node root) {
        if (root == null) return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.value);
        return list;
    }

    /**
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal02(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了58.06% 的用户
     * 内存消耗：37 MB, 在所有 Java 提交中击败了60.48% 的用户
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal03(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp.left != null){
                stack.push(temp.left);
            }
            if(temp.right != null){
                stack.push(temp.right);
            }
            res.add(0,temp.val);
        }
        return res;
    }
}
