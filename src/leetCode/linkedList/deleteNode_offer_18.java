package leetCode.linkedList;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 *
 *
 * 说明：
 *
 *     题目保证链表中节点的值互不相同
 *     若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 */
public class deleteNode_offer_18 {
    public ListNode deleteNode(ListNode head,int val){
        //头节点为null，直接返回即可
        if (head == null) return head;
        //头节点的值等于目标值，直接返回头节点的next结点即可
        if (head.value == val) return head.next;
        //保存前驱结点
        ListNode prev = head;
        //临时结点
        ListNode dummy = head.next;
        while (dummy != null) {
            if (dummy.value == val) break;
            prev = dummy;
            dummy = dummy.next;
        }
        //删除操作
        prev.next = dummy.next;
        return head;
    }
}
