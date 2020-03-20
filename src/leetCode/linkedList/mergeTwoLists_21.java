package leetCode.linkedList;
/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
public class mergeTwoLists_21 {
    public static void main(String[] args){
        //手动创建两个链表 l1 , a
        ListNode1 l1 = new ListNode1(1);
        ListNode1 l2 = new ListNode1(3);
        l1.next = l2;
        ListNode1 l3 = new ListNode1(4);
        l2.next = l3;

        ListNode1 a1 = new ListNode1(2);
        ListNode1 a2 = new ListNode1(5);
        a1.next = a2;
        ListNode1 a3 = new ListNode1(6);
        a2.next = a3;
        //ListNode1 node1 = mergeTwoLists(l1,a1);
        ListNode1 node = mergeTwoLists2(l1,a1);
        node.order();
    }
    //方式一：
    public static ListNode1 mergeTwoLists(ListNode1 l1,ListNode1 l2){
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        //
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    //方式二：
    public static ListNode1 mergeTwoLists2(ListNode1 l1,ListNode1 l2){
        ListNode1 prehead = new ListNode1(-1);

        ListNode1 prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
class ListNode1{
    int val;
    ListNode1 next;
    ListNode1(int x) { val = x; }
    public void order(){
        if (this == null){
            return;
        }else{
            System.out.println(this);
            if (this.next != null) {
                this.next.order();
            }else{
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "val=" + val ;
    }
}
