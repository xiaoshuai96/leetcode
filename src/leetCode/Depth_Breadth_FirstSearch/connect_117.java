package leetCode.Depth_Breadth_FirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 进阶：
 *     你只能使用常量级额外空间。
 *     使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 示例：
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，
 * 以指向其下一个右侧节点，如图 B 所示。
 */
public class connect_117 {
    public static void main(String[] args) {

    }
    public static Node connect(Node root){
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();

            Node last = null;
            //遍历每层树上的结点，确保每次只遍历一层
            for (int i = 1; i <= n; i++) {
                Node node = queue.poll();
                //将子节点加入队列尾部
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (i != 1) {
                    last.next = node;
                }
                last = node;

            }
        }
        return root;
    }

    class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
