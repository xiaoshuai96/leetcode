package leetCode.tree;

import leetCode.TreeNode;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class sortedListToBST_109 {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了66.15% 的用户
     * 内存消耗：40.9 MB, 在所有 Java 提交中击败了64.36% 的用户
     * 思路：通过快慢指针找到链表的中间元素先,和108题相似
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head){
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode fast = head,slow = head,pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        //切割链表
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left  = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

    public TreeNode sortedListToBST02(ListNode head) {
        return buildTree(head, null);
    }
    public TreeNode buildTree(ListNode head, ListNode tail){
        if(head == tail)
            return null;
        ListNode mid = getMid(head, tail);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(head, mid);
        root.right = buildTree(mid.next, tail);
        return root;

    }
    //获取中间节点
    public ListNode getMid(ListNode head, ListNode tail){
        ListNode slow = head, fast = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
