package leetCode.linkedList;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class deleteDuplicates_82 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        ListNode listNode = new deleteDuplicates_82().deleteDuplicates(head);
        while (listNode != null) {
            System.out.print(listNode.value+"\t");
        }
    }
    /**
     * tmp     prev   curr
     * -1  ->  1  ->  2  ->  3
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tmp  = dummy;
        dummy.next = head;
        ListNode prev = dummy.next;
        ListNode curr = dummy.next.next;
        while(curr != null){
            /**
             * tmp   prev                 curr
             * 1  ->  2  ->  2  ->  2  ->  3  ->  3  ->  4
             */
            if(curr.value == prev.value){
                //如果相等，继续往后找看还有没有了，有的话全部消灭
                while (curr != null && curr.value == prev.value) {
                    curr = curr.next;
                }
                tmp.next = curr;
                if (curr == null) {
                    return dummy.next;
                }
                prev = curr;
                curr = curr.next;
            }else{
                tmp  = tmp.next;
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
