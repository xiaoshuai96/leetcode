package leetCode.linkedList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 说明:
 *     应当保持奇数节点和偶数节点的相对顺序。
 *     链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class oddEvenList_328 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);
        oddEvenList(head);
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了77.47% 的用户
     * @param head
     * @return
     */
    public ListNode oddEvenList02(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            //奇数的next指向偶数的next，然后odd后移
            odd.next = even.next;
            odd = odd.next;
            //偶数的next指向奇数的next，然后even后移
            even.next = odd.next;
            even = even.next;
        }
        //奇数尾接上偶数头
        odd.next = evenHead;
        return head;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了94.24% 的用户
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        int count = 1;//用count变量来看当前结点是否为奇偶下标
        //两个临时结点
        ListNode odd  = new ListNode(-7);
        ListNode even = new ListNode(-8);
        ListNode o = odd;
        ListNode e = even;
        while (head != null) {
            if (count % 2 == 1) {
                o.next = head;
                o = o.next;
            } else {
                e.next = head;
                e = e.next;
            }
            count += 1;
            head = head.next;
        }
        e.next = null;
        o.next = even.next;
        return odd.next;
    }
}
