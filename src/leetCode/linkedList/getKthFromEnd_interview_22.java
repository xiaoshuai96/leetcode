package leetCode.linkedList;
/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。
 * 这个链表的倒数第3个节点是值为4的节点。
 *
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 */
public class getKthFromEnd_interview_22 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode node = getKthFromEnd(head, 1);
        System.out.println(node);
    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :37.6 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k){
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        for (int i = 0; i < count - k; i++) {
            head = head.next;
        }
        return head;
    }
}
