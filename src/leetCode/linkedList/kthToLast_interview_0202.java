package leetCode.linkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 *
 * 说明：
 * 给定的 k 保证是有效的。
 */
public class kthToLast_interview_0202 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了15.29% 的用户
     * 内存消耗：36.3 MB, 在所有 Java 提交中击败了51.33% 的用户
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        int res = -1;
        ListNode temp = head;
        Deque<Integer> queue = new LinkedList<>();
        while (temp != null) {
            queue.addLast(temp.value);
            temp = temp.next;
        }
        while (k != 0) {
            res = queue.pollLast();
            --k;
        }
        return res;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36 MB, 在所有 Java 提交中击败了79.40% 的用户
     * @param head
     * @param k
     * @return
     */
    public int kthToLast02(ListNode head, int k) {
        ListNode slow = head,fast = head;
        //fast指针先走k步
        while (k != 0) {
            fast = fast.next;
            --k;
        }
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.value;
    }
}
