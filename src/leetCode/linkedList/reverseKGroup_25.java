package leetCode.linkedList;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明：
 *     你的算法只能使用常数的额外空间。
 *     你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class reverseKGroup_25 {
    public static void main(String[] args) {

    }

    /**
     * recursion
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了81.50% 的用户
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        //每次统计链表中k个长度
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count != 0) {
                count--;
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }

    /**
     * Iterator
     * 执行用时：1 ms, 在所有 Java 提交中击败了40.93% 的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了76.40% 的用户
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup02(ListNode head, int k) {
        ListNode dummy = new ListNode(0), prev = dummy, curr = head, next;
        dummy.next = head;
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        head = dummy.next;
        //最外层循环表示有多少组需要交换
        for (int i = 0; i < length / k; i++) {
            //每次对这一组中k个元素进行交换
            for (int j = 0; j < k - 1; j++) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
            curr = prev.next;
        }
        return dummy.next;
    }
}
