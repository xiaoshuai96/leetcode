package leetCode.tree;

import java.util.ArrayList;
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
    public static List<Integer> preTraversal(Node root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        //首先将根结点压入栈中
        stack.push(root);
        while (!stack.isEmpty()) {
            //取出栈顶的结点
            Node temp = stack.pop();

            //先将结点的value加入list中
            list.add(temp.value);

            //再判断该节点的左右子树是否为空，如果不为空就将当前结点的左子树或者右子树加入栈中
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return list;
    }
}
