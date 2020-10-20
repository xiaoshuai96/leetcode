package leetCode.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class reorderList_143 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了28.37% 的用户
     * 内存消耗：40.3 MB, 在所有 Java 提交中击败了99.91% 的用户
     * @param head
     */
    public void reorderList(ListNode head){
        if (head == null || head.next == null || head.next.next == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        //由于链表不是线性表，无法通过下标快速获取结点，
        //所以使用集合来将各个节点存储，然后进行链表重构
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        int i = 0,j = list.size() - 1;
        /**
         * index  0      1      2      3      4
         *  node  1      2      3      4      5
         *
         * 1  ->  5
         * 5  ->  2  ->  3  ->  4  ->  5
         *
         * 2  ->  4
         * 4  ->  3  ->  4  -> 5
         *
         * 3  ->  null
         *
         *
         * 1  ->  5  ->  2  ->  4  ->  3  ->  null
         */
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;

    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了79.06% 的用户
     * 内存消耗：40.6 MB, 在所有 Java 提交中击败了99.50% 的用户
     * @param head
     */
    public void reorderList02(ListNode head){
        if (head == null) {
            return ;
        }
        ListNode mid = findMiddleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;//分割
        l2 = reverseList(l2);
        mergeList(l1,l2);
    }
    //找到链表的中间结点
    private ListNode findMiddleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //反转链表
    private ListNode reverseList(ListNode head){
        ListNode prev  = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    /**
     * 链表合并：将l2链表的各个节点依次插入到l1的每个结点后
     *
     * 1  ->  2  ->  3
     *
     * 5  ->  4
     *
     * 1  ->  5  ->  2  ->  4  ->  3  -> null
     * @param l1
     * @param l2
     */
    private void mergeList(ListNode l1,ListNode l2){
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}
