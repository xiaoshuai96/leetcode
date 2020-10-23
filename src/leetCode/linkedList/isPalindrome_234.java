package leetCode.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 */
public class isPalindrome_234 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了28.12% 的用户
     * 内存消耗：41.9 MB, 在所有 Java 提交中击败了44.36% 的用户
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        //通过遍历将各个结点的值加入list中
        while (head != null) {
            list.add(head.value);
            head = head.next;
        }
        //该数组用于将添加value值
        int[] arr = new int[list.toArray().length];
        //该变量用于记录数组的下标
        int temp = 0;
        for (int a : list) {
            arr[temp++] = a;
        }
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * towPointers
     *
     * 执行用时：2 ms, 在所有 Java 提交中击败了54.30% 的用户
     * 内存消耗：41 MB, 在所有 Java 提交中击败了95.93% 的用户
     * @param head
     * @return
     */
    public static boolean isPalindrome02(ListNode head){
        ListNode fast = head,slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //循环结束之后，此时的slow指向的就是链表的中心节点
        //after:后一半链表的的头节点  slow：前一半链表的尾节点
        ListNode before = head;
        ListNode after = reverseListNode(slow.next);

        ListNode p1 = head;
        ListNode p2 = after;
        boolean flag = true;
        while (p2 != null && flag) {
            if (p1.value != p2.value) {
                flag = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        //将链表恢复原样（只让你判断是否是回文链表，没让你破坏结构）
        slow.next = reverseListNode(after);
        return flag;
    }
    //反转链表
    private static ListNode reverseListNode(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}
