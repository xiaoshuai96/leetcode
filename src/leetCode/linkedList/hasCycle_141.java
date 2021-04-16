package leetCode.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 */
public class hasCycle_141 {
    public static void main(String[] args) {

    }

    /**
     * 哈希表
     * @param head
     * @return
     */
    public static boolean hashCycle(ListNode head){
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了54.83% 的用户
     *
     * 快慢指针：
     * 如果链表中存在“环”，那么快慢指针最终会相遇；如果不存在“环”，当快指针指向的结点为null或者
     * 快指针的next结点指向的结点为null；
     * @param head
     * @return
     */
    public static boolean hashCycle02(ListNode head){
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //快慢指针相遇之后循环截止
        while (slow != fast) {
            //当快指针指向的结点为null或者
            //快指针的next结点指向的结点为null说明链表中不存在环
            if (fast == null || fast.next == null) {
                return false;
            }
            //慢指针移动一个结点，快指针移动两个结点
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了23.86% 的用户
     * @param head
     * @return
     */
    public static boolean hashCycle03(ListNode head){
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head,fast = head;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
