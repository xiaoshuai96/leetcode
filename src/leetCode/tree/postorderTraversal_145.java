package leetCode.tree;

import java.util.ArrayList;
import java.util.List;

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
}
