package leetCode.linkedList;

import org.w3c.dom.ls.LSException;

import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶：
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 */
public class addTwoNumbers_II_445 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :40 MB, 在所有 Java 提交中击败了95.83%的用户
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode node1 = reverseListNode(l1);
        ListNode node2 = reverseListNode(l2);
        return reverseListNode(add(node1,node2));
    }
    //求和
    private static ListNode add(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int addOne = 0;
        while (l1 != null || l2 != null || addOne != 0) {
            int val1 = l1 == null ? 0 : l1.value;
            int val2 = l2 == null ? 0 : l2.value;
            int sum = val1 + val2 + addOne;
            temp.next = new ListNode(sum%10);
            temp = temp.next;
            addOne = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;

    }
    //反转
    private static ListNode reverseListNode(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 进阶：不对链表进行反转
     * 执行用时 :6 ms, 在所有 Java 提交中击败了42.06% 的用户
     * 内存消耗 :39.9 MB, 在所有 Java 提交中击败了95.83%的用户
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers02(ListNode l1, ListNode l2){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        //先将两个链表的数字分别压入栈中
        while (l1 != null) {
            s1.push(l1.value);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.value);
            l2 = l2.next;
        }
        int addOne = 0;//进位
        ListNode head = null;
        while (!s1.isEmpty() || !s2.isEmpty() || addOne != 0) {
            int sum = 0;
            sum += s1.isEmpty() ? 0 : s1.pop();
            sum += s2.isEmpty() ? 0 : s2.pop();
            ListNode temp = new ListNode(sum%10);
            temp.next = head;
            head = temp;
            addOne = sum/10;
        }
        return head;
    }
}
