package leetCode.linkedList;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 思路1（过于繁琐）：
 *  可先将两个链表翻转并转换成数字，相加之后翻转，再用一个链表表示他们的和。
 *
 *
 * */
public class addTwoNumbers_2 {
    public static void main(String[] args) {

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //先创建一个头节点
        ListNode temp = new ListNode(0);
        ListNode temp1 = l1,temp2 = l2,cur = temp;
        //记录进位
        int carry = 0;
        while (temp1 != null || temp2 != null) {
            //这里判断一号链表和二号链表是否为空，如果为空则返回0，如果不为空，返回当前结点的value
            int x = (temp1 != null)?temp1.value:0;
            int y = (temp2 != null)?temp2.value:0;

            //拿到两个链表对应位置的value的和
            int sum = x + y +carry;
            //得到进位  (0 or 1)
            carry = sum/10;

            //在cur结点的后面创建新的结点，构造器中的值就是sum的个位数
            cur.next = new ListNode(sum%10);
            //cur结点后移
            cur = cur.next;
            //指向两条链表的指针后移
            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;

        }
        //如果carry大于0说明在进行最后的求和时出现了进位，此时需要再创建一个结点
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return temp.next;
    }

    public static ListNode addTwoNumbers02(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int addOne = 0;
        while (l1 != null || l2 != null || addOne != 0) {
            int val1 = l1 == null ? 0 : l1.value;
            int val2 = l2 == null ? 0 : l2.value;
            int sum = val1 + val2 + addOne;
            temp.next = new ListNode(sum%10);
            temp = temp.next;
            addOne = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;

    }
}
class ListNode{
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}
