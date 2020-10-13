package leetCode.linkedList;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class swapPairs_24 {
    public static void main(String[] args) {

    }

    /**
     * 递归解法：
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：35.9 MB, 在所有 Java 提交中击败了99.77% 的用户
     *
     * 每次处理相邻的两个结点
     * 终止条件：该结点为null或者该结点的next结点为null，表示无法再交换
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head){
        //终止条件
        if (head == null || head.next == null) {
            return head;
        }
        //每次递归处理的是两个当前结点curr和curr.next
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        //到这里，newHead已经表示交换完成的子链表的头结点了
        newHead.next = head;
        return newHead;
    }

    /**
     * 迭代解法：
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.3 MB, 在所有 Java 提交中击败了85.71% 的用户
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs02(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode temp = dummyNode;//结点会交换，复制一份dummyNode
        while (temp.next != null && temp.next.next != null) {
            //使用两个临时结点来保存temp.next & temp.next.next
            ListNode node1 = temp.next;//node1:  1->2->3->4
            ListNode node2 = temp.next.next;//node2: 2->3->4
            //0 -> 2 -> 3 -> 4
            temp.next  = node2;
            //1 -> 3 -> 4
            node1.next = node2.next;
            //2 -> 1 -> 3 -> 4
            node2.next = node1;
            //temp: 1 -> 3 -> 4
            temp = node1;
        }
        return dummyNode.next;

    }
}
