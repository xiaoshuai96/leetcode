package leetCode.linkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class removeNthFromEnd_19 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了99.22% 的用户
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head,int n){
        //使用一个临时结点，让它的next结点指向头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int len = getLength(head);
        //复制一份dummy进行遍历，共遍历（链表长度-n）次
        ListNode curr = dummy;
        for (int i = 1;i < len - n + 1;i++){
            curr = curr.next;
        }
        //curr.next就是要删除的节点，让curr.next指向next的next结点即可
        curr.next = curr.next.next;
        return dummy.next;
    }
    //计算链表长度
    private int getLength(ListNode head){
        int count = 0;
        while (head != null) {
            ++count;
            head = head.next;
        }
        return count;
    }

    /**
     * twoPointers
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了98.61% 的用户
     *
     * 算法分析：
     * 使用两个指针first & second，刚开始的时候都指向的是head结点，我们先让两个指针之间保持n个距离，
     * 例如，second指针不动，first先走n步，然后两个指针都开始走，等到first指针指向的结点为null时，second
     * 指针指向的结点为要删除的结点
     * 为了方便删除，最开始在head结点前添加一个dummy结点，second指向dummy结点，这样在删除的时候
     * 只需要使second.next = second.next.next就完成了删除操作
     * 最终返回dummy.next，即结果
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd02(ListNode head,int n){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了20.95% 的用户
     * 内存消耗：36.7 MB, 在所有 Java 提交中击败了93.62% 的用户
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd03(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        //全部入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //依次弹出，共弹n次
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        //拿到栈顶的前驱节点
        ListNode prev = stack.peek();
        //进行删除操作
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
