package leetCode.tree;

import java.util.*;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class postorder_590 {
    /**
     * Iterator
     * 执行用时：4 ms, 在所有 Java 提交中击败了40.40% 的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了34.44% 的用户
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            Node pop = queue.pollLast();
            //从链表头插入值
            res.addFirst(pop.val);
            for (Node child : pop.children) {
                if (child != null) {
                    //默认将该节点加到链表尾部
                    queue.add(child);
                }
            }
        }
        return res;
    }

    /**
     * recursion
     * 执行用时：1 ms, 在所有 Java 提交中击败了91.48% 的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了44.40% 的用户
     * @param root
     * @return
     */
    List<Integer> res ;
    public List<Integer> postorder02(Node root){
        res = new LinkedList<>();
        order(root);
        return res;
    }
    private void order(Node root){
        if (root == null) {
            return ;
        }
        for (Node child : root.children) {
            order(child);
        }
        res.add(root.val);
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
