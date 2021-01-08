package leetCode.linkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
 * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，
 * 其不需要被置于左右两部分之间。
 *
 * 示例:
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 */
public class partition_interview_0204 {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(5);
        node.next.next = new ListNode(8);
        node.next.next.next = new ListNode(5);
        node.next.next.next.next = new ListNode(10);
        node.next.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next.next = new ListNode(1);
        new partition_interview_0204().partition(node,5);
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：37.5 MB, 在所有 Java 提交中击败了95.43% 的用户
     *
     * 算法思路：分为两个子链表完成
     * 左链表只放小于x的节点
     * 右链表只放大于等于x的节点
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        //虚拟节点
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);

        ListNode l = left;
        ListNode r = right;

        while(head != null) {
            if(head.value < x) {
                l.next = head;
                l = l.next;
            }else{
                r.next = head;
                r = r.next;
            }
            head = head.next;
        }
        l.next = right.next;
        r.next = null;

        return left.next;
    }
}
