package leetCode.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 */
public class removeDuplicateNodes_interview02_01 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：1052 ms, 在所有 Java 提交中击败了5.00%的用户
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes(ListNode head){
        if (head == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        ListNode pre = head,curr = head.next;
        while (curr != null) {
            if (!list.contains(curr.val)) {
                list.add(curr.val);
                pre = curr;
                curr = curr.next;
            } else {
                curr = curr.next;
                pre.next = curr;
            }
        }
        return head;
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了91.68% 的用户
     * 内存消耗：41.3 MB, 在所有 Java 提交中击败了100.00% 的用户
     * 利用set集合中的元素不重复性
     * 节点部分也是和第一种方法有所不同，但是比较好理解
     * 如果当前元素与之前遍历过的元素不重复，pos后移，否则，pos指向当前元素的下一个节点
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes02(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> occurred = new HashSet<Integer>();
        occurred.add(head.val);
        ListNode pos = head;
        // 枚举前驱节点
        while (pos.next != null) {
            // 当前待删除节点
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }

    /**
     * 进阶版本：双重循环，无法AC
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes03(ListNode head) {
        ListNode ob = head;
        while (ob != null) {
            ListNode oc = ob;
            while (oc.next != null) {
                if (oc.next.val == ob.val) {
                    oc.next = oc.next.next;
                } else {
                    oc = oc.next;
                }
            }
            ob = ob.next;
        }
        return head;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
