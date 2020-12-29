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

    }
    /**
     * 迭代版本
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了49.13% 的用户
     * tmp     prev   curr
     * -1  ->  1  ->  2  ->  3
     * @param head
     * @return
     */
    public ListNode deleteDuplicates01(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.value == cur.next.next.value) {
                ListNode temp = cur.next;
                //可能不止两个数字相同
                while (temp != null && temp.next != null && temp.value == temp.next.value ) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            }
            else
                cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 递归版本
     * 执行用时：1 ms, 在所有 Java 提交中击败了71.62% 的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了70.92% 的用户
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.value == head.next.value) {
            while (head != null && head.next != null && head.value == head.next.value) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }

    }
}
