package leetCode.linkedList;
/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 *
 * 提示：
 *     链表中节点数目为 n
 *     1 <= n <= 500
 *     -500 <= Node.val <= 500
 *     1 <= left <= right <= n
 */
public class reverseBetween_92 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new reverseBetween_92().reverseBetween(head,2,4);
    }

    /**
     * 1   2   3   4   5
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.1 MB, 在所有 Java 提交中击败了50.78% 的用户
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy,tmp = head;
        int flag = right - left + 1;
        while(left > 1){
            --left;
            prev = head;
            head = head.next;
        }
        int count = flag;
        while (count > 1) {
            --count;
            tmp = tmp.next;
        }
        //断开尾巴部分
        ListNode tail = tmp.next;
        tmp.next = null;
        prev.next = reverse(head,flag,tail);
        return dummy.next;
    }
    private ListNode reverse(ListNode head,int flag,ListNode tail){
        ListNode curr = head,prev = null;
        while(flag != 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            --flag;
        }
        head.next = tail;
        return prev;
    }
}
