package leetCode.linkedList;
/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class rotateRight_61 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new rotateRight_61().rotateRight(head,2);

    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了55.83% 的用户
     * 内存消耗：37.6 MB, 在所有 Java 提交中击败了89.80% 的用户
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k < 1 || head == null || head.next == null) return head;
        int len = 1;
        ListNode copy = head;
        //链表长度len
        while (copy.next != null) {
            ++len;
            copy = copy.next;
        }
        k %= len;
        if (k == 0) return head;

        //链表首尾相连
        copy.next = head;
        ListNode temp = head;
        int count = len - k;
        while (count > 1) {
            --count;
            temp = temp.next;
        }
        //断开操作
        ListNode newHead = temp.next;
        temp.next = null;

        return newHead;
    }
}
