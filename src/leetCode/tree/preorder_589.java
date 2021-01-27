package leetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 例如，给定一个 3叉树 :
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class preorder_589 {
    /**
     * recursion
     * 执行用时：1 ms, 在所有 Java 提交中击败了90.83% 的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了67.72% 的用户
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(res,root);
        return res;
    }

    private void dfs(List<Integer> res, Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node child : root.children) {
            dfs(res, child);
        }
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了39.27% 的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了53.00% 的用户
     * @param root
     * @return
     */
    public List<Integer> preorder02(Node root){
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList  <Node> list = new LinkedList<>();
        if(root == null) return res;
        list.add(root);
        while (!list.isEmpty()) {
            Node node = list.pollLast();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0 ; i--) {
                list.add(node.children.get(i));
            }
        }
        return res;
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
