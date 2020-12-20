package leetCode.linkedList;

import leetCode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *
 * 示例：
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 *
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 *
 * 示例：
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 */
public class addTwoNumbers_interview_0205 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(0);
        new addTwoNumbers_interview_0205().addTwoNumbers(l1,l2);
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了81.12% 的用户
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1,tmp2 = l2;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (tmp1 != null || tmp2 != null) {
            int s1 = tmp1 == null ? 0 : tmp1.value;
            int s2 = tmp2 == null ? 0 : tmp2.value;
            int ans = s1 + s2 + carry;
            if (ans > 9) {
                carry = 1;
                ans %= 10;
            } else {
                carry = 0;
            }
            temp.next = new ListNode(ans);
            temp = temp.next;
            tmp1 = tmp1 == null ? null : tmp1.next;
            tmp2 = tmp2 == null ? null : tmp2.next;
        }
        if (carry != 0) {
            temp.next = new ListNode(1);
        }
        return dummy.next;
    }
}
