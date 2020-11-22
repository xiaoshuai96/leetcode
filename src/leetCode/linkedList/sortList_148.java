package leetCode.linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：
 *     你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 *
 *     链表中节点的数目在范围 [0, 5 * 104] 内
 *     -105 <= Node.val <= 105
 */
public class sortList_148 {
    public static void main(String[] args) {

    }
    /**
     * 执行用时：744 ms, 在所有 Java 提交中击败了5.04% 的用户
     * 内存消耗：42.8 MB, 在所有 Java 提交中击败了35.98% 的用户
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

    /**
     * 执行用时：13 ms, 在所有 Java 提交中击败了16.06% 的用户
     * 内存消耗：48 MB, 在所有 Java 提交中击败了5.06% 的用户
     * @param head
     * @return
     */
    public ListNode sortList02(ListNode head){
        List<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Object[] array = list.toArray();
        Arrays.sort(array);
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        for (int i = 0; i < array.length; i++) {
            int t = (int) array[i];
            tmp.next = new ListNode(t);
            tmp = tmp.next;
        }
        return dummy.next;
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了53.08% 的用户
     * 内存消耗：46.5 MB, 在所有 Java 提交中击败了21.37% 的用户
     * @param head
     * @return
     */
    public ListNode sortList03(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        //快慢指针找到中间结点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        //链表分割
        slow.next = null;
        ListNode left  = sortList03(head);
        ListNode right = sortList03(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
  }
}
