package leetCode.linkedList;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 *
 */
public class removeElements_203 {
    public static void main(String[] args) {

    }

    /**
     * 哨兵模式
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.92% 的用户
     * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了20.46%的用户
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val){
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode curr = head,prev = temp;
        while(curr != null){
            if(curr.value == val){
                prev.next = curr.next;
            }else{
                prev = curr;
            }
            curr = curr.next;
        }
        return temp.next;
    }
}
