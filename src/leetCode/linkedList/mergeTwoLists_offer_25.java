package leetCode.linkedList;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 */
public class mergeTwoLists_offer_25 {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.00% 的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了65.97% 的用户
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.value < l2.value) {
                    temp.next = l1;
                    l1 = l1.next;
                } else {
                    temp.next = l2;
                    l2 = l2.next;
                }
            } else if (l1 == null) {
                temp.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        return dummy.next;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.00% 的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了85.56% 的用户
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists02(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        //遍历就结束之后，如果其中有一个链表没有被遍历完，那么就看l1是否
        //被遍历完了，如果是，直接将l2接在temp的后面，否则就将l1接在后面
        temp.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
