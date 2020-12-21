package leetCode.linkedList;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class deleteDuplicates_83 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了40.84% 的用户
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = head,curr = head.next;
        while(curr != null){
            if(curr.value == prev.value){
                prev.next = curr.next;
                curr = prev.next;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
