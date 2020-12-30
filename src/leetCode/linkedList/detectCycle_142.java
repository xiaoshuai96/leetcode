package leetCode.linkedList;
/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *     你是否可以使用 O(1) 空间解决此题？
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 *
 *
 * 提示：
 *     链表中节点的数目范围在范围 [0, 104] 内
 *     -105 <= Node.val <= 105
 *     pos 的值为 -1 或者链表中的一个有效索引
 */
public class detectCycle_142 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了90.21% 的用户
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null){
            //判断是否有环存在，如果存在快慢指针必定相遇
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                //之后，重置fast为head
                fast = head;
                //两个指针同时开始走，等到它们相遇的时候就是环的起始节点，返回即可
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
