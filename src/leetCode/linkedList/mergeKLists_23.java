package leetCode.linkedList;

import leetCode.linkedList.ListNode;

/**
 *合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 */
public class mergeKLists_23 {
    public static void main(String[] args){

    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode node = mergeTwo(lists[0],null);
        for(int i = 1; i < lists.length;i++){
            node = mergeTwo(node,lists[i]);
        }
        return node;
    }
    public ListNode mergeTwo(ListNode l1,ListNode l2){
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while(l1 != null && l2 != null){
            if(l1.value <= l2.value){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}
