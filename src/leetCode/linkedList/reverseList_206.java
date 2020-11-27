package leetCode.linkedList;
/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 */
public class reverseList_206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reverseList(head);
    }

    /**
     * 迭代方法
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :38.2 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head){
        ListNode prev = null;//存放当前结点的前一个结点
        ListNode curr = head;//存放当前结点
        while (curr != null) {
            ListNode next = curr.next;//该结点存储当前结点的下一个结点
            curr.next = prev;//当前结点的下一结点指向前一个结点
            prev = curr;//然后将当前结点赋值给前一个结点
            curr = next;//移动当前结点curr的位置
        }
        return prev;

    }
    //递归方法
    public static ListNode reverseList2(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
