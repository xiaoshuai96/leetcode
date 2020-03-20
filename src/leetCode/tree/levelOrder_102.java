package leetCode.tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * */
public class levelOrder_102 {
    public static void main(String[] args){
        Node root;
        root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.left.left = new Node(0);
        root.left.right = new Node(0);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        //List<List<Integer>> list = LevelOrder(root);
        List<List<Integer>> list = LevelOrder(root);
        System.out.println(list);
    }

    public static List<List<Integer>> LevelOrder(Node root) {
        //这个集合用于返回所需要的结果
        List<List<Integer>> res = new ArrayList<>();
        //判断传入的结点是否为空
        if(root == null) return res;

        //创建队列对象，存储根结点
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //记录当前队列中的元素个数（1）
            int size = queue.size();

            //该list对象用于存储队列中poll出的子节点的value
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size;i++){
                Node cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                list.add(cur.value);
            }
            res.add(list);
        }
        return res;
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

}

